package baseball;

public class Application {

    public static void main(String[] args) {

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        Defender.reroll();
        Session.startGame();

    }
}
