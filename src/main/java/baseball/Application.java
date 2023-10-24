package baseball;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Game game = new Game(); // Game 로직을 담당할 객체를 생성한다.
            game.start();   // 숫자 야구 게임을 시작한다.
            if (game.isEnd()) { // 게임이 끝났는지 확인한다.
                break;
            }
        }
    }
}
