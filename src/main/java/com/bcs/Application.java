/**
 * Black Crow Systems Limited.
 * 2016.
 * This code is released under GNU General Public License Version 3.
 * See LICENSE for full details of the license conditions.
 */
package com.bcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ramindursingh
 *
 */
@Configuration  //Tells the application that this is a configuration for Spring
@EnableAutoConfiguration // This tells Spring Boot to run autoconfiguration
@ComponentScan // Tells Spring to autoscan this and sub-packages
public class Application extends SpringBootServletInitializer{

    // Tells Spring to make a single static call to the run method
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    // Override the configure method to point to itself, so that Spring can find the main configuration.
    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder springApplication) {
        return springApplication.sources(Application.class);
    }
}
