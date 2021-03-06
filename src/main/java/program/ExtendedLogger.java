package program;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author Rene
 */
public class ExtendedLogger {

    // Save global logging to html file
    static public void enableHtml() throws IOException {
        // create an HTML formatter
        Logger logger = Logger.getLogger("");
        FileHandler fileHTML = new FileHandler("Logging.html");

        HtmlFormatter formatterHTML = new HtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);
    }

    // change logging level for all logger
    static public void setDebugLevel(Level newLvl) {
        Logger logger = LogManager.getLogManager().getLogger("");
        logger.setLevel(newLvl);

        Handler[] handlers = logger.getHandlers();
        for (Handler h : handlers) {
            if (h instanceof FileHandler) {
                h.setLevel(newLvl);
            }
        }
    }

    static public void useConsole(boolean b) {
        Logger logger = Logger.getLogger("");
        Handler[] handlers = logger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            logger.removeHandler(handlers[0]);
        }
        if (b) {
            ConsoleHandler handler = new ConsoleHandler();
            logger.addHandler(handler);
            Formatter formatter = new ConsoleFormatter();
            handler.setFormatter(formatter);

        }

    }
}
