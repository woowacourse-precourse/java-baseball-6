package computer;

import java.util.HashMap;
import java.util.Map;
public class Hint {

    private Map<String, Integer> hint= new HashMap<>();

    private static Hint hintSingleton=new Hint();

    private Hint(){}

    public void save(int strike,int ball){
        hintClear();
        hint.put("strike", strike);
        hint.put("ball", ball);
    }

    public int loadStrike(){
        return hint.get("strike");
    }

    public int loadBall(){
        return hint.get("ball");
    }

    public void hintClear(){
        hint.clear();
    }

    public static Hint getInstance(){
        return hintSingleton;
    }
}
