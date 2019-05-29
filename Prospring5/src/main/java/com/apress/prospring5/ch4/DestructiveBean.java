package com.apress.prospring5.ch4;

import java.io.File;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBean implements InitializingBean{
    private File file;
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialingzing Bean");
        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You mus specify the filePath property of " + DestructiveBean.class
            );
        }

        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists: "  + file.exists());
    }

    public void destroy() {
        System.out.println("Destroying Bean");

        if(!file.delete()){
            System.err.println("ERROR: failed to delete file.");
        }

        System.out.println("File exists: " + file.exists());
    }

    public static void main(String[] args) throws Exception{
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        DestructiveBean bean = ctx.getBean("destructiveBean", DestructiveBean.class);
        ctx.destroy();
        System.out.println("Called destroy()");
    }

}