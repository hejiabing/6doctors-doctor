package cn.sixdoctors.doctor.config;

import cn.sixdoctors.doctor.interceptor.CrossFieldInterceptor;
import cn.sixdoctors.doctor.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * Created by wpc on 2017/5/21.
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Resource
    private AuthInterceptor authInterceptor;

    @Resource
    private CrossFieldInterceptor crossFieldInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptor).addPathPatterns("/api/*");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/admin/*");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/*");
        registry.addInterceptor(crossFieldInterceptor);

        super.addInterceptors(registry);
    }

    //因为新加了拦截器，这里需要重新设置资源地址
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations(
                "classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
