package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compare {
    public Map<String, Integer> compareNumber(List<Integer> randomNumber, List<Integer> userNumber){
        Map<String,Integer> result=new HashMap<>();
        result.put("strike",0);
        result.put("ball",0);
        for (int i = 0; i < randomNumber.size(); i++) {
            if(randomNumber.get(i)==userNumber.get(i)){
                result.put("strike",result.get("strike")+1);
            } else if (randomNumber.contains(userNumber.get(i))) {
                result.put("ball",result.get("ball")+1);
            }
        }
        return result;
    }
}
