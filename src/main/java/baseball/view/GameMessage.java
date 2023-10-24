package baseball.view;

public class GameMessage {

    public void scoreMessage(int strikeCount, int ballCount) {
        if(ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }

        if(ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }

        if(ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public void gameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
