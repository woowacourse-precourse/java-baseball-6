package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.Baseballs;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.domain.Baseball.*;

public class BallGeneratorService {

    public Baseballs generateRandomBalls() {
        return new Baseballs(createRandomBalls(generateRandomBallNumbers()));
    }

    private List<Integer> generateRandomBallNumbers() {
        Set<Integer> ballNumbers = new HashSet<>();
        while (ballNumbers.size() < BALL_SIZE) {
            ballNumbers.add(Randoms.pickNumberInRange(MIN_BALL, MAX_BALL));
        }
        return new ArrayList<>(ballNumbers);
    }

    private List<Baseball> createRandomBalls(List<Integer> ballNumbers) {
        return ballNumbers.stream()
                .map(Baseball::new)
                .collect(Collectors.toList());
    }

    public Baseballs generatePlayerBalls(String playerGuess) {
        return new Baseballs(convertStringToBalls(playerGuess));
    }

    private List<Baseball> convertStringToBalls(String playerGuess) {
        if (playerGuess == null || playerGuess.isBlank()) {
            throw new IllegalArgumentException("입력값은 공백이 들어갈 수 없습니다.");
        }

        return IntStream.range(0, playerGuess.length())
                .mapToObj(index -> new Baseball(playerGuess.charAt(index) - '0'))
                .collect(Collectors.toList());
    }
}
