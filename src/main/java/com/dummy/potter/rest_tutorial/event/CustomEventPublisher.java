package com.dummy.potter.rest_tutorial.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * publisher handle passed through setter is a instance of application context
 * spring provides the context as publisher to all beans implementing ApplicationEventPublisherAware interface
 */
@Component
public class CustomEventPublisher implements ApplicationEventPublisherAware {
    ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(ApplicationEvent event){
        publisher.publishEvent(event);
    }

}
