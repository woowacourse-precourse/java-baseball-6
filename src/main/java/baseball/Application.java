package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        while (true) {
            game.startGame();
            if (!game.isRestartGame()) {
                System.out.println("게임 종료");
                return;
            }


        }

    }

}
