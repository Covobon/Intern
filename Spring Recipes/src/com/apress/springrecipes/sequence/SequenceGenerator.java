package com.apress.springrecipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
    private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger count = new AtomicInteger();
    @Autowired
    private Map<String, PrefixGenerator> prefixGenerators;
    private PrefixGenerator prefixGenerator;

    public SequenceGenerator() {
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getInitial() {
        return initial;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequence(){
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(initial)
                .append(count.getAndIncrement())
                .append(suffix);
        return builder.toString();
    }

    @Autowired(required=false)
    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    @Autowired
    public void myOwnCustomInjectionName(PrefixGenerator prefixGenerator){
        this.prefixGenerator = prefixGenerator;
    }
}
