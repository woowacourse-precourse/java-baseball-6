package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final String target;

    public Computer() {
        this.target = getRandomNumber();
    }

    public String getRandomNumber() {
        StringBuilder targetString = new StringBuilder();

        while (targetString.length() < 3) {
            int randomPickNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetString.toString().contains(String.valueOf(randomPickNumber))) {
                targetString.append(randomPickNumber);
            }
        }

        return targetString.toString();
    }

    public String numberCheck(String num) {
        char[] targetChars = this.target.toCharArray();
        char[] numChars = num.toCharArray();

        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < 3; i++) {
            if (targetChars[i] == numChars[i]) {
                strikeCnt++;
            } else {
                if (this.target.contains(String.valueOf(numChars[i]))) {
                    ballCnt++;
                }
            }
        }

        String answer = (ballCnt != 0 ? ballCnt + "볼 " : "") + (strikeCnt != 0 ? strikeCnt + "스트라이크"
                : "").trim();
        return answer.isEmpty() ? "낫싱" : answer;
    }
}
