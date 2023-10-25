package baseball.service;

import baseball.model.GameResult;

import java.util.List;

public class GameService {
    private int ball;
    private int strike;
    public GameResult getResult(List<Integer> comNumber, List<Integer> userNumber) {
        // 초기화
        ball = 0;
        strike = 0;

        // strike, ball 판별
        for (int i = 0; i < comNumber.size(); i++) {
            if(comNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            } else if (comNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }

        return new GameResult(ball, strike);
    }
}
