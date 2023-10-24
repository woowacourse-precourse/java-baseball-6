package baseball.view;

public class Output {
    public static Output getInstance() {
        return new Output();
    }

    public void printStartGame() {
        System.out.println(OutputConstants.START_GAME_STRING);
    }

    public void printInputNumber() {
        System.out.print(OutputConstants.INPUT);
    }
}
