package baseball.service;

import baseball.domain.BaseBall;
import baseball.repository.BaseBallRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BaseBallService {
    BaseBallRepository baseBallRepository;

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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (playerBallNumbers.get(i).equals(computerBallNumbers.get(j)) && i == j) {
                    score[1]++;
                    break;
                } else if (playerBallNumbers.get(i).equals(computerBallNumbers.get(j)) && i != j) {
                    score[0]++;
                    break;
                }
            }
        }
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
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
