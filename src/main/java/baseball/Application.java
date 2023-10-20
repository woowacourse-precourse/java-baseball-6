package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = Game.generate();
        try {
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 애플리케이션을 종료합니다.");
        }

    }
}
