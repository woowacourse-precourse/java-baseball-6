package baseball.handler.validation;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.assertj.core.internal.Numbers;

public class Validator {

    private final static Properties properties = new Properties();

    private final static int ANSWERLENGTH = Integer.parseInt((String)properties.get("ANSWER.LENGTH"));
    private final static int ST_RANGE = Integer.parseInt((String) properties.get("NUM.RANGE.ST"));
    private final static int ED_RANGE = Integer.parseInt((String) properties.get("NUM.RANGE.ED"));

    static {
        try {
            FileInputStream propertyFile = new FileInputStream("rule.properties");
            properties.load(propertyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Validator(){
    }

    public static void answerValidate(List<Integer> userAnswer){
        dupleNumValidate(userAnswer);
        lengthValidate(userAnswer);
        typeValidate(userAnswer);
    }
    private static void dupleNumValidate(List<Integer> userAnswer){
        Set<Integer> answerSet = new HashSet<>();
        if(answerSet.size() != userAnswer.size()){
            throw new IllegalArgumentException();
        }
    }
    private static void lengthValidate(List<Integer> userAnswer){
        if(userAnswer.size() != ANSWERLENGTH ){
            throw new IllegalArgumentException();
        }
    }
    private static void typeValidate(List<Integer> userAnswer){
        for (int num: userAnswer ) {
            if(num < ST_RANGE || num > ED_RANGE){
                throw new IllegalArgumentException();
            }
        }
    }
}
