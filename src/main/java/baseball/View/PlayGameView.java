package baseball.View;

public class PlayGameView {
    public static void printInputNum() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printCorrectAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    // Case 별로 나누기
    public static void printHint(int ballCount, int strikeCount) {

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
        if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if(ballCount != 0 && strikeCount != 0 ) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }
}
