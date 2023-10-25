package baseball.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import baseball.domain.GameInfo;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.constant.MessageConst.*;
import static baseball.constant.MessageConst.SUCCESS_MSG;
import static baseball.constant.NumberConst.*;

/**
 * 게임의 비즈니스 로직을 처리하는 클래스
 */
public class GameService {
    public List<Integer> createRandomDistinctThreeDigit() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < INPUT_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (!randomNumbers.contains(randomNum)) {
                randomNumbers.add(randomNum);
            }
        }
        return randomNumbers;
    }

    public void countStrikeAndBall(GameInfo gameInfo, String userInput) {
        List<Integer> randomNumbers = gameInfo.getRandomNumbers();
        List<Integer> userInputs = stringToList(userInput);
        int strikeCount = (int) IntStream.range(0, userInputs.size())
                .filter(index -> randomNumbers.get(index).equals(userInputs.get(index)))
                .count();
        int ballCount = (int) IntStream.range(0, userInputs.size())
                .filter(index -> !randomNumbers.get(index).equals(userInputs.get(index)))
                .filter(index -> randomNumbers.contains(userInputs.get(index)))
                .count();
        gameInfo.updateBall(ballCount);
        gameInfo.updateStrike(strikeCount);
    }

    public StringBuilder createResultMessageForInput(int ballCount, int strikeCount) {
        StringBuilder outputResult = new StringBuilder();
        if (ballCount == 0 && strikeCount == 0) {
            outputResult.append(NOTHING);
        }
        if (ballCount != 0) {
            outputResult.append(ballCount).append(BALL).append(" ");
        }
        if (strikeCount != 0) {
            outputResult.append(strikeCount).append(STRIKE);
        }
        if (strikeCount == SUCCESS_STRIKE) {
            outputResult.append("\n");
            outputResult.append(SUCCESS_MSG);
        }
        return outputResult;
    }

    public List<Integer> stringToList(String userInput) {
        return userInput.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }
}
