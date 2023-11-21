package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private List<String> computerNum;

    public Baseball() {
        this.computerNum = pickComputerNum();
    }

    private List<String> pickComputerNum() {
        List<String> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            String randomNum = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }
        return computerNum;
    }

    public String getResult(int inputNum) {
        String result = "";

        int[] countResult = countStrikeBall(inputNum);
        int strike = countResult[1];
        int ball = countResult[2];

        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        if (result.isEmpty()) {
            result += "낫싱";
        }
        return result;
    }

    private boolean isStrike(int index, String targetNum) {
        return targetNum.equals(computerNum.get(index));
    }

    private boolean isBall(String targetNum) {
        return computerNum.contains(targetNum);
    }

    private int[] countStrikeBall(int input) {
        int[] result = new int[2];

        String userNum = Integer.toString(input);
        for (int i = 0; i < 3; i++) {
            String targetNum = userNum.substring(i, i + 1);
            if (isStrike(i, targetNum)) {
                result[0]++;
                continue;
            }
            if (isBall(targetNum)) {
                result[1]++;
            }
        }
        return result;
    }

}
