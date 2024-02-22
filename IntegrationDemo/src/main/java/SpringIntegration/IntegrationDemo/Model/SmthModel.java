package SpringIntegration.IntegrationDemo.Model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
public class SmthModel {
    private long id;
    private String title;
}

