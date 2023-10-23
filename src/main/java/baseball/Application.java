package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Defender.reroll();

        // 게임 시작, 입력 받기
        System.out.println("숫자 야구 게임을 시작합니다.");
        Session.startGame();

    }
}
