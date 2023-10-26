package baseball;

import java.util.List;

public class BaseBallScore {
    private BaseBallScore() {
    }

    private static int[] score(List<Integer> computerNum, List<Integer> personNum) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < personNum.size(); i++) {
            int comNum = computerNum.get(i);
            int perNum = personNum.get(i);
            if (comNum == perNum) {
                strike++;
            } else if (computerNum.contains(perNum)) {
                ball++;
            }
        }

        return new int[] {strike, ball};
    }

    public static void printScore(List<Integer> computerNum, List<Integer> personNum) {
        int count[] = BaseBallScore.score(computerNum, personNum);
        StringBuilder sb = new StringBuilder();
        if (count[1] > 0) {
            sb.append(count[1]).append("볼").append(" ");
        }
        if (count[0] > 0) {
            sb.append(count[0]).append("스트라이크");
        }
        System.out.println(sb.toString().isEmpty() ? "낫싱" : sb);
    }
}