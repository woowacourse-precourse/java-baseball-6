package baseball;

import java.util.List;

public class Core {

    public int getStrikeCount(List<Integer> computerNumber, int[] digits) {
        int strikeCount = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == digits[i]) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public int getBallCount(List<Integer> computerNumber, int[] digits, int strikeCount) {
        int ballCount;
        int containCount = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.contains(digits[i])) {
                containCount += 1;
            }
        }
        ballCount = containCount - strikeCount;
        return ballCount;
    }

    public void printResult(int strikeCount, int ballCount) {
        String result = "";
        if (strikeCount == 0 & ballCount == 0) {
            result += "낫싱";
        }
        if (ballCount > 0) {
            result += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            result += strikeCount + "스트라이크";
        }
        System.out.println(result);
    }

    public boolean isEnd(int strikeCount) {
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
