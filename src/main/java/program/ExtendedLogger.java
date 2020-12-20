package program;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author Rene
 */
public class ExtendedLogger {
    
    // Save global logging to txt
    static public void setup() throws IOException {
        FileHandler fileTxt = new FileHandler("Logging.txt");
        fileTxt.setFormatter(new SimpleFormatter());
        
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.addHandler(fileTxt);
    }
    
    // change loggin level for all logger
    static public void setDebugLevel(Level newLvl) {
        Logger rootLogger = LogManager.getLogManager().getLogger("");
        rootLogger.setLevel(newLvl);
        
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler h : handlers) {
            if (h instanceof FileHandler) {
                h.setLevel(newLvl);
            }
        }
    }
}
