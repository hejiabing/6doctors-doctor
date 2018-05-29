package cn.sixdoctors.doctor.config;

import cn.sixdoctors.doctor.interceptor.CrossFieldInterceptor;
import cn.sixdoctors.doctor.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wpc on 2017/5/21.
 */
@Configuration
public class BeansInitializer {

    @Bean(name = "AuthInterceptor")
    public AuthInterceptor tokenInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public CrossFieldInterceptor crossFieldInterceptor() {
        return new CrossFieldInterceptor();
    }

}
