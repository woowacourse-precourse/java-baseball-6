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

    public void printJudgement(String judgement) {
        System.out.println(judgement);
    }

    public void printCongratulatoryMessage() {
        System.out.println(OutputConstants.CONGRATULATORY_MESSAGE);
    }

    public void printContinueGame() {
        System.out.println(OutputConstants.CONTINUE_GAME);
    }
}
