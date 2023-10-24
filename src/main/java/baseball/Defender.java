package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Defender {
    private static final StringBuilder target = new StringBuilder();
    private static final StringBuilder Score = new StringBuilder();
    private static int ballCount = 0;
    private static int strikeCount = 0;

    // 정답 생성 - 3자리 숫자
    public static void reroll() {
        target.setLength(0);
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)) {
                temp.add(randomNumber);
            }
        }
        for (int i = 0; i < 3; i++) {
            target.append(temp.get(i));
        }
        System.out.println(target); // 테스트용
    }

    // 승리조건 확인
    public static boolean isThreeStrikes() {
        return strikeCount == 3;
    }

    // 정답 확인하기 - 볼, 스트라이크, 낫싱 출력하기
    public static void printScore(String answer) {
        calculateBallCount(answer);
        calculateStrikeCount(answer);

        // TODO: if문 분기 정리
        if (ballCount == 0 && strikeCount == 0) {
            Score.append("낫싱");
        }
        System.out.println(Score);
        Score.setLength(0);
    }

    // 정답 확인하기 - 볼
    private static void calculateBallCount(String answer) {
        ballCount = 0;

        // TODO: indent 정리(depth: 3)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && answer.charAt(i) == target.charAt(j)) {
                    ballCount++;
                }
            }
        }
        if (ballCount != 0) {
            Score.append(String.format("%d볼", ballCount));
        }
    }

    // 정답 확인하기 - 스트라이크
    private static void calculateStrikeCount(String answer) {
        strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == target.charAt(i)) {
                strikeCount++;
            }
        }
        if (ballCount != 0) {
            Score.append(' ');
        }
        if (strikeCount != 0) {
            Score.append(String.format("%d스트라이크", strikeCount));
        }
    }
}
