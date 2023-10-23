package baseball.user;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Computer {

    List<Integer> baseballNumbers;
    private boolean isStrikeOut = false;

    public void generateBaseballNumbers() {
        initStrikeOut();

        baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber);
            }
        }
    }

    private void initStrikeOut() {
        isStrikeOut = false;
    }

    public void printBaseballResult(List<Integer> playerBaseballNumbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < baseballNumbers.size(); i++) {
            for (int j = 0; j < playerBaseballNumbers.size(); j++) {
                boolean isSameNumber = baseballNumbers.get(i).intValue() == playerBaseballNumbers.get(j).intValue();
                boolean isSamePosition = (i == j);
                if (isSameNumber && isSamePosition) {
                    strikeCount++;
                    break;
                }
                if (isSameNumber) {
                    ballCount++;
                    break;
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        if (ballCount > 0) {
            sj.add(ballCount + "볼");
        }
        if (strikeCount > 0) {
            sj.add(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            sj.add("낫싱");
        }

        System.out.println(sj);

        if (strikeCount > 2) {
            isStrikeOut = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean isStrikeOut() {
        return isStrikeOut;
    }
}
