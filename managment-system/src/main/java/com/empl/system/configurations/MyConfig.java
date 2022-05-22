package com.empl.system.configurations;

import ch.qos.logback.core.joran.event.stax.StartEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextStartedEvent;

@Configuration
public class MyConfig implements ApplicationListener<ContextStartedEvent> {

    @Bean(name = "myBean")
    @Scope("prototype")
    public int show(){
        return new String("hello").hashCode();
    }

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Started");
    }
}
