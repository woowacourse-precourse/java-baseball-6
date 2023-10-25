package baseball;

public class Result {
    public static void showResultPrompt(int ballCount, int strikeCount) {
        //ballCount -= strikeCount;

        if (ballCount == 0 && strikeCount == 3) {
            System.out.printf("%d스트라이크%n", strikeCount);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 0) {
            System.out.printf("%d볼%n", ballCount);
        } else if (ballCount == 0) {
            System.out.printf("%d스트라이크%n", strikeCount);
        } else if (ballCount != 0 && strikeCount != 0) {
            System.out.printf("%d볼 %d스트라이크%n", ballCount, strikeCount);
        }

    }
}
