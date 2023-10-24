package baseball.controller;

import baseball.model.Score;
import java.util.List;
import java.util.Objects;

public class GameController {

    Score score;


    public int[] checkNumber(List<Integer> comList, List<Integer> userList) {
        int[] strikeAndBall = new int[2];
        this.score = new Score();

        for (int comIdx = 0; comIdx < comList.size(); comIdx++) {
            if (comList.contains(userList.get(comIdx))) {
                if (Objects.equals(comList.get(comIdx), userList.get(comIdx))) {
                    score.strike++;
                } else {
                    score.ball++;
                }
            }
        }

        strikeAndBall[0] = score.strike;
        strikeAndBall[1] = score.ball;
        return strikeAndBall;
    }
}
