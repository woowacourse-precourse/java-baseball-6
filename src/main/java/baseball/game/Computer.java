package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public String randomNum;

    public void setRandomNum() {
        List<Integer> list = new ArrayList<>();
        randomNum = "";
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        for (Integer item : list) {
            randomNum += Integer.toString(item);
        }
    }

    public boolean printResult(String playerNum) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int index = 0; index < randomNum.length(); index++) {
            if (isSamePositionAndValue(randomNum, playerNum, index)) {
                strikeCount++;
            } else {
                if (containsValue(randomNum, playerNum.charAt(index))) {
                    ballCount++;
                }
            }
        }

        String message = generateMessage(strikeCount, ballCount);
        System.out.println(message);
        return strikeCount == 3;
    }

    private String generateMessage(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            return "3스트라이크";
        } else if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        } else {
            StringBuilder message = new StringBuilder();
            if (ballCount > 0) {
                message.append(ballCount).append("볼 ");
            }
            if (strikeCount > 0) {
                message.append(strikeCount).append("스트라이크");
            }
            return message.toString();
        }
    }

    boolean isSamePositionAndValue(String str1, String str2, int idx) {
        return str1.charAt(idx) == str2.charAt(idx);
    }

    boolean containsValue(String str, char c) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
}
