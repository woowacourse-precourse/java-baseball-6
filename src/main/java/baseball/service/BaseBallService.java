package baseball.service;

import baseball.domain.BaseBall;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static baseball.util.Constant.*;
import static camp.nextstep.edu.missionutils.Console.*;

public class BaseBallService {

    public boolean isThreeStrike(BaseBall player, BaseBall computer) {
        List<Integer> playerBallNumbers = player.getInputBallNumber();
        List<Integer> computerBallNumbers = computer.getInputBallNumber();

        return IntStream.range(0, playerBallNumbers.size())
                .allMatch(i -> Objects.equals(playerBallNumbers.get(i), computerBallNumbers.get(i)));
    }

    public int[] checkStrikeAndBallCount(BaseBall player, BaseBall computer) {
        List<Integer> playerBallNumbers = player.getInputBallNumber();
        List<Integer> computerBallNumbers = computer.getInputBallNumber();

        int[] score = new int[2];
        IntStream.range(0, playerBallNumbers.size()).forEach(i -> {
            IntStream.range(0, computerBallNumbers.size()).forEach(j -> {
                if (playerBallNumbers.get(i).equals(computerBallNumbers.get(j))) {
                    if (i == j) {
                        score[1]++;
                    } else {
                        score[0]++;
                    }
                }
            });
        });
        return score;
    }

    public String notificationResult(int[] result) {
        if (result[0] > 0 && result[1] > 0) {
            return String.format(BALL_AND_STRIKE_FORMAT, result[0], result[1]);
        } else if (result[0] > 0) {
            return String.format(BALL_FORMAT, result[0]);
        } else if (result[1] > 0) {
            return String.format(STRIKE_FORMAT, result[1]);
        }
        return NOTHING;
    }

    public int restartGame() {
        System.out.println(FINISH_GAME);
        System.out.println(RESTART_GAME);

        return Integer.parseInt(readLine());
    }
}
