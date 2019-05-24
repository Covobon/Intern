import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RunTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/drivermanager-conf-02.xml");
        context.refresh();


    }
}