package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        game play = new game();
        do {
            play.init();
            play.ran();
            while (play.finishCheck() == 0) {
                play.userInput();
                play.compareNumbers();
                play.printResult();
            }
        } while (play.playerChoice() == 1);
    }
}
