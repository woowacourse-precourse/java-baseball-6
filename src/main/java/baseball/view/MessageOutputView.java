package baseball.view;

public class MessageOutputView {
    public static void GameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void BallMessage() {
        System.out.println("볼");
    }

    public static void StrikeMessage() {
        System.out.println("스트라이크");
    }

    // 계산된 볼과 스트라이크를 메시지로 출력하는 메소드
    public static void BallStrikeCountMessage(int num) {
        System.out.print(num);
    }

    public static void IncoorectAnswerMessage() {
        System.out.println("낫싱");
    }

    public static void EndGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
