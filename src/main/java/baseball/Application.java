package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Baseball game = new Baseball();

        while (true) {

            game.runGame();

            if(game.restart()) {
                break;
            }
        }

    }
}