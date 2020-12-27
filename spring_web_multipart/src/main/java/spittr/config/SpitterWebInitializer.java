package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("tmp/spittr/uploads", 2097152, 4194304, 0));
    }
}
