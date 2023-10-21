package baseball;

public class Controller {

    private static final String GAME_RESTART = "1";
    private static final String GAME_END = "2";

    private boolean isGameFinished = false;

    public void play() {
        Player player = new Player();
        Inputview.startGame();
        while (true) {
            GameCompare gameCompare = new GameCompare();
            playGame(player, gameCompare);
            String inputNumber = Inputview.reStart();
            if (isReStart(inputNumber)) {
                break;
            }
        }
    }

    private boolean isReStart(String inputNumber) {
        if (inputNumber.equals(GAME_RESTART)) {
            isGameFinished = false;
        }
        if (inputNumber.equals(GAME_END) ) {
            return true;
        }
        return false;
    }

    private void playGame(Player player, GameCompare gameCompare) {
        while (!isGameFinished) {
            String inputNumber = Inputview.inputNumber();
            player.updateNumbers(inputNumber);
            boolean endGameSign = gameCompare.updateGameCompare(player);
            String result = gameCompare.showResult();
            OutputView.showResult(result);
            isGameFinished = endGameSign;
            if (Boolean.TRUE.equals(endGameSign)) {
                break;
            }
        }
    }
}