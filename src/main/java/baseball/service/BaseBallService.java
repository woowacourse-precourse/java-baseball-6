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
}
