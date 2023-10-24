package baseball.utils;

public class MessageUtils {
    public void startGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputUserNumberMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void retryGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void ballStrikeMessage(int ballCnt, int strikeCnt) {
        if (strikeCnt == 3) {
            System.out.println(strikeCnt + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0) {
            System.out.println(ballCnt + "볼");
        } else if (ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }

}
