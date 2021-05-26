package pl.mradziewicz.ToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mradziewicz.ToDo.TaskConfigurationProperties;

@RestController
public class InfoController {
    private DataSourceProperties dataSource;

    private TaskConfigurationProperties myProp;

    @Autowired
    InfoController(final DataSourceProperties dataSource, final TaskConfigurationProperties myProp) {
        this.dataSource = dataSource;
        this.myProp = myProp;
    }

    @GetMapping("/info/url")
    String getUrl() {
        return dataSource.getUrl();
    }

    @GetMapping("/info/prop")
    boolean getMyProp() {
        return myProp.isAlloMultipleTaskFromTemplate();
    }
}
