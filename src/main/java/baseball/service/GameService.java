package baseball.service;

import static baseball.properties.Properties.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import baseball.model.GameResult;



public class GameService {

    private final List<Integer> gameRandomNumbers;

    public GameService(List<Integer> gameRandomNumbers) {
        this.gameRandomNumbers = gameRandomNumbers;
    }

    public List<Integer> parseInput(String userInputString) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> duplicateCheckSet = new HashSet<>();
        checkLength(userInputString,GAME_SIZE);
        for (String input : userInputString.split("")) {
            Integer converted = converIntegerOrThorwIllegalException(input);
            if (DIGIT_START <= converted && converted > DIGIT_END) {
                throw new IllegalArgumentException(String.format("%d와 %d 사이의 숫자만 입력가능합니다.", DIGIT_START, DIGIT_END));
            }
            if (duplicateCheckSet.contains(converted)) {
                throw new IllegalArgumentException(("중복된 숫자는 입력이 불가능합니다. "));
            }
            duplicateCheckSet.add(converted);
            result.add(converted);
        }
        return result;
    }

    public GameResult calculateGameResult(List<Integer> userInputNumbers) {
        int ballcount = countBall(gameRandomNumbers,userInputNumbers);
        int strikeCount = 0;

        if (ballcount == 0) {
            return new GameResult(ballcount,strikeCount);
        }
        strikeCount = countStrike(gameRandomNumbers,userInputNumbers);
        ballcount -= strikeCount;
        return new GameResult(ballcount,strikeCount);
    }

    private int countStrike(List<Integer> gameRandomNumbers, List<Integer> userInputNumbers) {
        int count = 0;
        for (int i = 0; i < GAME_SIZE; i++) {
            if (gameRandomNumbers.get(i).equals(userInputNumbers.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    private int countBall(List<Integer> comNumbers, List<Integer> userNumbers) {
        int totalSize = comNumbers.size() + userNumbers.size();
        int differentBallCount = (int)Stream.concat(comNumbers.stream(),userNumbers.stream()).distinct().count();
        return totalSize - differentBallCount;
    }

    private Integer converIntegerOrThorwIllegalException(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException expected) {
            throw new IllegalArgumentException(String.format("숫자형식이 아닙니다. 문자:%s", input));
        }
    }

    private void checkLength(String userInputString,int targetSize) {
        if (userInputString.length() != targetSize) {
            throw new IllegalArgumentException(String.format("입력받은 사용자 문자의 길이 = %d , 제한길이 %d",
                    userInputString.length(), targetSize));
        }
    }
}
