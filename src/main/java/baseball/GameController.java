package baseball;

public class GameController {
    private boolean playing = true;

    public void start() {
        System.out.println(GameMessage.GAME_START.getMessage());

        while (playing) {
            playRound();
            askForNextRound();
        }
    }

    private void playRound() {
        ThreeBalls targetBalls = new ThreeBalls();
        Round round = new Round(targetBalls);
        round.start();
    }

    private void askForNextRound() {
        System.out.printf(GameMessage.CONTINUE_ROUND.getMessage());

        int inputNumber = PromptHandler.readNextRoundResponseNumber();
        playing = NextRoundResponse.getByResponseNumber(inputNumber).getResponseStatus();
    }
}
