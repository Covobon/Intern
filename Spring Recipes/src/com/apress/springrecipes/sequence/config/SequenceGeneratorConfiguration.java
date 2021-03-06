package com.apress.springrecipes.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.apress.springrecipes.sequence.SequenceGenerator;

@Configuration
public class SequenceGeneratorConfiguration {

    @Bean
    public SequenceGenerator sequenceGenerator(){
        SequenceGenerator sequen = new SequenceGenerator();
        sequen.setPrefix("30");
        sequen.setSuffix("A");
        sequen.setInitial(10000);
        return sequen;
    }
}
