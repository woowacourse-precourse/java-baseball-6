package baseball.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Baseball {

    private Map<Integer, Integer> dict;

    public Baseball(String numbers) {
        List<Integer> list = new ArrayList<>();
        for(char c : numbers.toCharArray()) {
            if(!Character.isDigit(c)) throw new IllegalArgumentException();
            list.add(Character.getNumericValue(c));
        }
        build(list);
    }

    public Baseball(List<Integer> numbers) {
        build(numbers);
    }

    private void build(List<Integer> numbers) {
        if(numbers.size() != 3) throw new IllegalArgumentException();
        for(Integer n : numbers) {
            if(n == 0) throw new IllegalArgumentException();
        }

        dict = new HashMap<>();
        for(int i=0;i<3;i++) {
            dict.put(numbers.get(i), i);
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
