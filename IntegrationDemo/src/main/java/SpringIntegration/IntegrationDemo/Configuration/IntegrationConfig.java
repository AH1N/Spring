package SpringIntegration.IntegrationDemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel textInputChanel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWritesChanel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWritesChanel")
    public GenericTransformer<String,String> mainTransformer(){
        return text -> {
//что-то происходит с входными данными
            return text;
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWritesChanel")
    public FileWritingMessageHandler messageHandler1(){
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File("C:/Users/Zahar/Downloads/IntegrationDemo/FileStorage"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}

