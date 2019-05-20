package com.apress.prospring5.ch2.decoupled;

//renderer interface
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}




