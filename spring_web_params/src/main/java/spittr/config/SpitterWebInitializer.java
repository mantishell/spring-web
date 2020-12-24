package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 在 Servlet 3.0 环境中，容器会在类路径中查找实现 javax.servlet.ServletContainerInitializer 接口的类， 如果能发现的话，
 * 就会用它来配置 Servlet 容器。
 *
 * Spring 提供了这个接口的实现，名为 SpringServletContainerInitializer，这个类反过来又会查找实现 WebApplicationInitializer 的类并将配置的任务交给它们来完成。
 * Spring 3.2 引入了一个便利的 WebApplicationInitializer 基础实现，也就 是 AbstractAnnotationConfigDispatcherServletInitializer 因为我们的 SpittrWebAppInitializer
 * 扩展了 AbstractAnnotationConfigDispatcherServletInitializer（同时也就实现了 WebApplicationInitializer），因此当部署到 Servlet 3.0 容器中的时候，容器会自动发现它，
 * 并用它来配置 Servlet 上下文。
 *
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 将一个或多个路径映射到Dispatcher-Servlet上
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * ContextLoaderListener加载应用中其他的bean，如：
     * 驱动应用后端的中间层和数据层组件
     * @return 返回带有 @Configuration 注解的类，将会用来配置 ContextLoaderListener 创建的应用上下文中的 bean
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * DispatcherServlet 加载包含 Web 组件的 bean,如：
     * 控制器、视图解析器以及处理器映射
     * @return 返回带有 @Configuration 注解的类，将会用来定义 DispatcherServlet 应用上下文中的 bean
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }
}
