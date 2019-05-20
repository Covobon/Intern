package com.apress.springrecipes.shop.config;

import com.apress.springrecipes.shop.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:discounts.properties")
@ComponentScan("com.apress.springrecipes.shop")
public class ShopConfiguration {

    @Value("${endofyear.discount:0}")
    private double specialEndofyearDiscountField;

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages_en_US.properties");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer
        propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean
    public BannerLoader bannerLoader(){
        BannerLoader b1 = new BannerLoader();
        b1.setBanner(banner);
        return b1;
    }

    @Bean
    public Product aaa(){
        Battery p1 = new Battery("AAA", 2.5);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw(){
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700);
        return p2;
    }

    @Bean Product dvdrw(){
        Disc p2 = new Disc("DVD-RW", 3.0);
        p2.setCapacity(700);
        return p2;
    }
}
