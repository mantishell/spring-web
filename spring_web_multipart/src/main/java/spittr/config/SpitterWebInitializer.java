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

    /**
     * 在 AbstractAnnotationConfig-DispatcherServletInitializer 将 DispatcherServlet 注册到 Servlet 容器中之后，就会调用
     * customizeRegistration()，并将 Servlet 注册后得到的 Registration.Dynamic 传递进来。通过重载 customizeRegistration()
     * 方法，我们可以对 Dispatcher-Servlet 进行额外的配置。
     */
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("tmp/spittr/uploads", 2097152, 4194304, 0));
    }
}
