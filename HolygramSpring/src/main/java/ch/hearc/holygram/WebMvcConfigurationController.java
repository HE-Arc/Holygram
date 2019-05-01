package ch.hearc.holygram;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan("org.springframework.security.samples.mvc")
public class WebMvcConfigurationController implements WebMvcConfigurer {
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		// something
    }
}
