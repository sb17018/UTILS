package ie.yawer;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class EmbeddedTomcat extends Thread {

    @Override
    public void run() {

        final int PORT = 8765;
        final String HOST_NAME = "localhost";
        final String SERVLET_NAME = "helloServlet";
        final String SERVLET_MAPPING = "/hello";
        final String NAME_OF_FILE_CREATED_TO_GET_CONTEXT = "webapp";

        Tomcat tomcat = new Tomcat();

        // Socket settings
        tomcat.setPort(PORT);
        tomcat.setHostname(HOST_NAME);

        // Creates folder to get context path to tomcat
        File docBase = new File(NAME_OF_FILE_CREATED_TO_GET_CONTEXT );
        docBase.mkdir();
        Context context = tomcat.addContext("", docBase.getAbsolutePath());

        Tomcat.addServlet(context, SERVLET_NAME, new HelloServlet());
        context.addServletMappingDecoded(SERVLET_MAPPING, SERVLET_NAME);

        // Force connector creation
        tomcat.getConnector();

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.join("", "Tomcat started on http://",HOST_NAME,":",String.valueOf(PORT),SERVLET_MAPPING));
        tomcat.getServer().await();
    }
}
