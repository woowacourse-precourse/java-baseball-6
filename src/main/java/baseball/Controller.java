package baseball;

import java.util.List;

public class Controller {
    public void play() {
        boolean isGameFinished = false;

        while (true) {
            Inputview.gameStart();
            newGame(isGameFinished);
            String inputReStartNum = Inputview.reStart();

            if ("1".equals(inputReStartNum)) {
                isGameFinished = false;
            }
            if ("2".equals(inputReStartNum)) {
                break;
            }
        }
    }

    private static void newGame(boolean isGameFinished) {
        List<Integer> randomNum = new RandomNum().getExistRandomNum();
        while (!isGameFinished) {
            List<Integer> inputNum = Inputview.input();
            GameCompare gameCompare = new GameCompare();
            gameCompare.compareBall(randomNum, inputNum);
            gameCompare.compareStrike(randomNum, inputNum);

            if (Boolean.TRUE.equals(OutputView.showResult(gameCompare.getball(), gameCompare.getstrike()))) {
                break;
            }
        }
    }
}
