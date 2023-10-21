package baseball;

import java.util.List;

public class GameScoreHandler {
    public static int calculateScore(List<Integer> computer, List<Integer> user){
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i))) {
                ballCount++;
            }
            if (user.get(i) == computer.get(i)) {
                strikeCount++;
                ballCount--;
            }
        }
        printScore(ballCount, strikeCount);
        return strikeCount;
    }
    private static void printScore(int ballCount, int strikeCount){
        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + "볼");

        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        if (strikeCount == 3) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
            System.out.println("게임 종료");
        }
    }
}
