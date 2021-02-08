package program;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @author Rene
 */
public class ConsoleFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        builder.append(record.getLevel() + ": ");
        builder.append(formatMessage(record));
        builder.append(System.lineSeparator());
        return builder.toString();
    }

}
