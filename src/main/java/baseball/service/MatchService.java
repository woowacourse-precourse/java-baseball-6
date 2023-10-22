package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class MatchService {
    private int ball;
    private int strike;
    private List<Integer> result;
    public List<Integer> getResult(List<Integer> comNumber, List<Integer> userNumber) {
        result = new ArrayList<>();
        ball = 0;
        strike = 0;


        for (int i = 0; i < comNumber.size(); i++) {
            if(comNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            } else if (comNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }

        result.add(ball);
        result.add(strike);

        return result;
    }
}
