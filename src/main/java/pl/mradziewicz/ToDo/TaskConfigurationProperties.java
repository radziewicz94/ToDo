package pl.mradziewicz.ToDo;

import org.springframework.context.annotation.Configuration;

@Configuration("task")
public class TaskConfigurationProperties {
    private boolean allowMultipleTaskFromTemplate;

     public boolean isAlloMultipleTaskFromTemplate() {
        return allowMultipleTaskFromTemplate;
    }

     public void setAlloMultipleTaskFromTemplate(final boolean allowMultipleTaskFromTemplate) {
        this.allowMultipleTaskFromTemplate = allowMultipleTaskFromTemplate;
    }
}
