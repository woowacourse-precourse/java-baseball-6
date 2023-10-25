package baseball;

import static baseball.Constant.GAME_NUM_SIZE;
import static baseball.Constant.MAX_RANDOM_NUMBER;
import static baseball.Constant.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class GameModel {
    private final List<String> computerNum;

    public GameModel() {
        this.computerNum = createComputerNumber();
    }

    public List<String> createComputerNumber() {
        Set<String> numSet = new HashSet<>();
        while (numSet.size() < GAME_NUM_SIZE) {
            String randNum = String.valueOf(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
            numSet.add(randNum);
        }
        return new ArrayList<>(numSet);
    }

    public String matchPlayerNum(List<String> playerNum) {
        long ballCount = computeBallCount(playerNum);
        long strikeCount = computeStrikeCount(playerNum);

        return getGameResult(ballCount, strikeCount);
    }

    public void verifyPlayerNum(List<String> playerNum) {
        isNonDigit(playerNum);
        isThreeDigitNumber(playerNum);
        hasRepeatedDigitNumber(playerNum);
        hasZeroDigitNumber(playerNum);
    }

    private long computeBallCount(List<String> playerNum) {
        return playerNum.stream()
                .filter(num -> computerNum.contains(num) && !computerNum.get(playerNum.indexOf(num)).equals(num))
                .count();
    }

    private long computeStrikeCount(List<String> playerNum) {
        return IntStream.range(0, GAME_NUM_SIZE)
                .filter(i -> computerNum.get(i).equals(playerNum.get(i)))
                .count();
    }

    private String getGameResult(long ballCount, long strikeCount) {
        String result = "";
        result += (ballCount > 0) ? ballCount + "볼" : "";
        result += (strikeCount > 0) ? (result.isEmpty() ? "" : " ") + strikeCount + "스트라이크" : "";

        return result.isEmpty() ? "낫싱" : result;
    }

    // 사용자가 입력한 값이 숫자인지 확인한다.
    private void isNonDigit(List<String> playerNum) {
        playerNum.forEach(pNum -> {
            try {
                Integer.parseInt(pNum);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다. 게임이 종료됩니다.");
            }
        });
    }

    // 사용자가 입력한 값이 3자리 숫자인지 확인한다.
    private void isThreeDigitNumber(List<String> playerNum) {
        if (playerNum.size() != 3) {
            throw new IllegalArgumentException("숫자가 3자리가 아닙니다. 게임이 종료됩니다.");
        }
    }

    // 사용자가 입력한 값에서 2개 이상 중복되는 숫자가 있는 경우
    private void hasRepeatedDigitNumber(List<String> playerNum) {
        Set<String> digitNumSet = new HashSet<>();

        playerNum.stream()
                .filter(pNum -> !digitNumSet.add(pNum))
                .findAny()
                .ifPresent(pNum -> {
                    throw new IllegalArgumentException("서로 다른 3자리의 수가 아닙니다. 게임이 종료됩니다.");
                });
    }

    // 사용자가 입력한 값에 0이 있는 경우
    private void hasZeroDigitNumber(List<String> playerNum) {
        if (playerNum.contains("0")) {
            throw new IllegalArgumentException("입력 값에 0이 포함되어 있습니다. 게임이 종료됩니다.");
        }
    }
}

