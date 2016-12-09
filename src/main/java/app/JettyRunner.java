package app;

import com.google.common.io.Resources;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class JettyRunner {

    private static final Logger logger = LoggerFactory.getLogger(JettyRunner.class);


    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();

        URL webxml = Resources.getResource("WEB-INF/web.xml");
        URL resourceBase = Resources.getResource("webapp");

        logger.info("web.xml location: {}", webxml);
        logger.info("resources location: {}", resourceBase);

        context.setDescriptor(webxml.toString());
        context.setResourceBase(resourceBase.toString());
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        context.setLogUrlOnStart(true);


        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase(resourceBase.toString());
        resourceHandler.setWelcomeFiles(new String[]{ "index.html" });
        resourceHandler.setDirectoriesListed(true);

        HandlerList handlers = new HandlerList();

        handlers.setHandlers(new Handler[] { resourceHandler, context });

        server.setHandler(handlers);

        server.start();

        logger.info("Server started on: http://localhost:8080");

        server.join();
    }
}
