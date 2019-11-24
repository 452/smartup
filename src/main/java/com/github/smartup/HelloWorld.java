package com.github.smartup;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author ihor.lavryniuk
 */
public class HelloWorld implements BundleActivator {

    private CamelContext camelContext = new DefaultCamelContext();

    public void start(BundleContext ctx) throws Exception {
        Date date = new Date();
        System.out.println("Hello world." + date);
        camelContext.addRoutes(new RouteBuilder() {
            public void configure() {
                from("timer://logOutputTimer?period=3000")
                        .transform()
                        .simple("new ${date:now:yyyyMMdd} ${in.header.number} range 100..199")
                        .log("123")
                        .process(it -> {
                            System.out.println(it);
                        });
            }
        });
        camelContext.start();

        File file = new File("/tmp/bundle.txt");
        FileWriter fr = new FileWriter(file, true);
        fr.write("\ndate: " + date);
        fr.close();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        camelContext.stop();
        System.out.println("Goodbye world.");
    }

}