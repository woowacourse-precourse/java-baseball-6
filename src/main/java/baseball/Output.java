package baseball;

public class Output {

    public void gameStart() {
        System.out.println(OutputMessage.GAME_START.getMessage());
    }

    public void inputPlayerNumber() {
        System.out.print(OutputMessage.INPUT_PLAYER_NUMBER.getMessage());
    }

    public void inningEnd() {
        System.out.println(OutputMessage.INNING_END.getMessage());
    }

    public void inputGameCommand() {
        System.out.println(OutputMessage.INPUT_GAME_COMMAND.getMessage());
    }

    public void gameEnd() {
        System.out.println(OutputMessage.GAME_END.getMessage());
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println("[ERROR] " + exception.getMessage());
    }
}
