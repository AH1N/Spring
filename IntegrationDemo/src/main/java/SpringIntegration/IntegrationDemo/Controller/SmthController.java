package SpringIntegration.IntegrationDemo.Controller;

import SpringIntegration.IntegrationDemo.Model.SmthModel;
import SpringIntegration.IntegrationDemo.Service.FileGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/")
public class SmthController {

    @Autowired
    private FileGateWay fileGateWay;

    @PostMapping
    public ResponseEntity<SmthModel> addSmthEnity(@RequestBody SmthModel smthModel){
        fileGateWay.writeToFile(smthModel.getTitle()+".txt", smthModel.toString() );
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
