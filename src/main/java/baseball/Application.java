package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseBallGame game = new BaseBallGame(); // 게임을 시작하는 객체
        game.start(); // 게임 시작
    }
}
