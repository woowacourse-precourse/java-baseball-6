package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.model.Constants.*;

public class BaseballGame {

    public List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            addComputerNumber(computerNumber, randomNumber);
        }
        return computerNumber;
    }

    private static void addComputerNumber(List<Integer> computerNumber, int randomNumber) {
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    private static Integer countCommonElements(List<Integer> computerNumber, List<Integer> userNumber){
        // List를 Set으로 변환하여 중복을 제거
        Set<Integer> set1 = new HashSet<>(computerNumber);
        Set<Integer> set2 = new HashSet<>(userNumber);

        // 두 set의 교집합
        set1.retainAll(set2);

        return set1.size();
    }

    private static Integer countStrikeElements(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;

        for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private static Integer countBallElements(List<Integer> computerNumber, List<Integer> userNumber) {
        int ballCount = countCommonElements(computerNumber, userNumber) - countStrikeElements(computerNumber, userNumber);

        return ballCount;
    }

    public List<Integer> countBallAndStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        Integer strikeCount = countStrikeElements(computerNumber, userNumber);
        Integer ballCount = countBallElements(computerNumber, userNumber);
        List<Integer> ballAndStrike = new ArrayList<>();

        ballAndStrike.add(ballCount);
        ballAndStrike.add(strikeCount);

        return ballAndStrike;
    }
}
