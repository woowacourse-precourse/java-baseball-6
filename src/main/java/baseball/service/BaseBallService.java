package baseball.service;

import baseball.domain.BaseBall;
import baseball.util.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static baseball.util.Constant.*;

public class BaseBallService {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            return String.format("%d볼 %d스트라이크\n", result[0], result[1]);
        } else if (result[0] > 0) {
            return String.format("%d볼\n", result[0]);
        } else if (result[1] > 0) {
            return String.format("%d스트라이크\n", result[1]);
        }
        return "낫싱";
    }

    public int restartGame() throws IOException {
        System.out.println(FINISH_GAME);
        System.out.println(RESTART_GAME);

        return Integer.parseInt(br.readLine());
    }
}
