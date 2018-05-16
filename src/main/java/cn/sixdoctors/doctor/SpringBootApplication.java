package cn.sixdoctors.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by hejiabing on 2018/5/14.
 */
@EnableAutoConfiguration
@ComponentScan
public class SpringBootApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
