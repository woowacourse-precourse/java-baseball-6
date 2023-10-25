package baseball.config;

import java.io.FileInputStream;
import java.util.Properties;

public class GameProperty {

    private final static Properties properties = new Properties();

    static {
        try {
            FileInputStream propertyFile = new FileInputStream("src/main/resources/rule.properties");
            properties.load(propertyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static int ANSWERLENGTH = Integer.parseInt((String) properties.get("ANSWER.LENGTH"));
    private final static int ST_RANGE = Integer.parseInt((String) properties.get("NUM.RANGE.ST"));
    private final static int ED_RANGE = Integer.parseInt((String) properties.get("NUM.RANGE.ED"));

    public static int getAnswerlength() {
        return ANSWERLENGTH;
    }

    public static int getStRange() {
        return ST_RANGE;
    }

    public static int getEdRange() {
        return ED_RANGE;
    }


}
