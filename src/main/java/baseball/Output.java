package baseball;

public class Output {

    public void gameStart() {
        System.out.println(OutputMessage.GAME_START.getMessage());
    }

    public void inputPlayerNumber() {
        System.out.print(OutputMessage.INPUT_PLAYER_NUMBER.getMessage());
    }

    public void printResult(Result result) {
        System.out.println(getResultMessage(result));
    }

    private String getResultMessage(Result result) {
        if (result.isNothing()) {
            return Inning.NOTHING.getMessage();
        }
        return getBallStrikeMessage(result);
    }

    private String getBallStrikeMessage(Result result) {
        StringBuilder message = new StringBuilder();
        result.ballMessage(message);
        result.whiteSpaceMessage(message);
        result.strikeMessage(message);
        return message.toString();
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
