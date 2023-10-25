package baseball;

import java.util.List;

public class Result {
    private int ballCount = 0;
    private int strikeCount = 0;

    // 비교 함수 실행해서 결과 출력
    public String compareNumbers(List<Integer> computer, List<Integer> player) {
        count(computer, player);
        String result = output();
        ballCount = 0;
        strikeCount = 0;
        return result;
    }

    // 숫자 비교하여 볼,스트라이크 카운트
    private void count(List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (player.get(i).equals(computer.get(j))) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }
    }

    // 결과 출력
    private String output() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        } else if (ballCount != 0 && strikeCount == 0) {
            return ballCount + "볼";
        } else if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + "스트라이크";
        } else {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
    }
}
