package baseball.service;

import baseball.domain.BaseBall;
import baseball.repository.BaseBallRepository;

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
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(playerBallNumbers.get(i).equals(computerBallNumbers.get(j)) && i == j) {
                    score[0]++;
                    break;
                } else if(playerBallNumbers.get(i).equals(computerBallNumbers.get(j)) && i != j) {
                    score[1]++;
                    break;
                }
            }
        }
        return score;
    }
}
