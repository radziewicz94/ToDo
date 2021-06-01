package pl.mradziewicz.ToDo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ConfigurationProperties("task")
public class TaskConfigurationProperties {
    private Template template;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(final Template template) {
        this.template = template;
    }

    public static class Template{
        private boolean allowMultipleTaskFromTemplate;

        public boolean isAllowMultipleTaskFromTemplate() {
            return allowMultipleTaskFromTemplate;
        }

        public void setAllowMultipleTaskFromTemplate(final boolean allowMultipleTaskFromTemplate) {
            this.allowMultipleTaskFromTemplate = allowMultipleTaskFromTemplate;
        }
    }
}
