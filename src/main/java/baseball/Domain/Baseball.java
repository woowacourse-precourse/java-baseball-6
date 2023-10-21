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
        validateSize(numbers);
        validateZero(numbers);

        dict = new HashMap<>();
        for(int i=0;i<3;i++) dict.put(numbers.get(i), i);
    }

    private static void validateZero(List<Integer> numbers) {
        for(Integer n : numbers) if(n == 0) throw new IllegalArgumentException();
    }

    private static void validateSize(List<Integer> numbers) {
        if(numbers.size() != 3) throw new IllegalArgumentException();
    }

    public BaseballScore compare(Baseball baseball) {

        int ball = 0, strike = 0;
        for(Map.Entry<Integer, Integer> pair : dict.entrySet()) {
            int number = pair.getKey(), index = pair.getValue();
            if(baseball.contains(number)) {
                if(baseball.isStrike(number, index)) strike++;
                else ball++;
            }
        }

        return new BaseballScore(ball, strike);

    }

    private boolean contains(int number) {
        return dict.containsKey(number);
    }

    private boolean isStrike(int number, int index) {
        return dict.get(number) == index;
    }

}
