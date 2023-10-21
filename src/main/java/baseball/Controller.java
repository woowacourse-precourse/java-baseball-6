package baseball;

public class Controller {
    private boolean isGameFinished = false;
    public void play() {
        Player player = new Player();

        Inputview.startGame();
        while(!isGameFinished) {
            String inputNumber = Inputview.inputNumber();
            player.updateNumbers(inputNumber);
            GameCompare gameCompare = new GameCompare();
            boolean endGameSign = gameCompare.updateGameCompare(player);
            String result = gameCompare.showResult();
            OutputView.showResult(result);
            isGameFinished = endGameSign;
            Inputview.reStart();
        }
    }
}