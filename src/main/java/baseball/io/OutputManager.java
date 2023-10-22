package baseball.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OutputManager {
    private Properties commonMessage;

    public OutputManager() throws IOException {
        InputStream commonMessageProperties = this.getClass().getResourceAsStream("/commonMessage.properties");

        this.commonMessage = new Properties();
        this.commonMessage.load(commonMessageProperties);
    }

    public void printMessage(String messageCommand) {
        System.out.println(commonMessage.getProperty(messageCommand));
    }
}
