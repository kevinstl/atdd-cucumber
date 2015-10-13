package com.ctl.example.cucumber.config;

import com.ctl.security.ips.client.config.ClientConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by kevin on 10/11/15.
 */
@Configuration
@ComponentScan("com.ctl.example.cucumber")
@Import({
    ClientConfig.class
})
public class CucumberConfiguration {

    public CucumberConfiguration() {
        System.out.println("test");
    }
}
