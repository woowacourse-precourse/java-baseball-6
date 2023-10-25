package baseball.game.model;

import baseball.game.model.dto.GameResultDto;

import java.util.List;

public class NumbersComparator {
    public static final int NUMBERS_SIZE = 3;

    public GameResultDto checkNumber(Numbers numbers, List<Integer> randomNumbers) {
        List<Integer> playerNumbers = numbers.getNumbers();
        int strike = getStrikeCount(randomNumbers, playerNumbers); //스트라이크 개수
        int ball = getBallCount(randomNumbers, playerNumbers, strike);

        return new GameResultDto(ball, strike);
    }

    private int getStrikeCount(List<Integer> randomNumbers,
                               List<Integer> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            int randomNumber = randomNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            if (randomNumber == playerNumber) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private int getBallCount(List<Integer> randomNumbers,
                             List<Integer> playerNumbers,
                             int strike) {
        if (strike >= NUMBERS_SIZE) {
            return 0;
        }

        int answer = (int) randomNumbers
                .stream()
                .filter(playerNumbers::contains)
                .count();

        return answer - strike;
    }
}
