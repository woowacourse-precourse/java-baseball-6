package baseball;

import java.util.HashMap;
import java.util.Map;

public class Baseball {

    private Map<Integer, Integer> dict;

    public Baseball(String numbers) {

        if(numbers.length() != 3) throw new IllegalArgumentException();
        for(char c : numbers.toCharArray()) {
            if(!Character.isDigit(c)) throw new IllegalArgumentException();
            if(c == '0') throw new IllegalArgumentException();
        }

        dict = new HashMap<>();
        for(int i=0;i<3;i++) {
            Integer n = Character.getNumericValue(numbers.charAt(i));
            dict.put(n, i);
        }

    }

    public BaseballScore compare(Baseball baseball) {

        BaseballScore baseballScore = new BaseballScore();

        for(Map.Entry<Integer, Integer> pair : dict.entrySet()) {
            if(!baseball.dict.containsKey(pair.getKey())) continue;
            if(baseball.dict.get(pair.getKey()) == pair.getValue()) baseballScore.strike++;
            else baseballScore.ball++;
        }

        return baseballScore;

    }

}
