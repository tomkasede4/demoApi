package com.example.demo.configurations;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeterConfigs {
    @Bean
    public CompositeMeterRegistry getMeterRegistry() {
        CompositeMeterRegistry meterRegistry = new CompositeMeterRegistry();
        meterRegistry.config()
                .commonTags("application","demoApp");
        return meterRegistry;
    }
    @Bean
    public Counter counter(){
        var registry = getMeterRegistry();
        var counter = registry.counter("order.books");
        return counter;
    }
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
}
