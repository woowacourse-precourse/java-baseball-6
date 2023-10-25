package baseball;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        View view = new View();
        view.printGameStartingMsg();
        Input input = new Input();
        while (true) {
            view.printInputMessage();
            final String inputNumberStr = input.getNumberInput();
            Score score = getCompareResultWithInputNumberAndComputerNumber(
                    inputNumberStr, computer);
            view.printScore(score);
            if (score.hasWinScore()) {
                String inputNum = input.getGameExitOrRestartInput();
                if (Integer.parseInt(inputNum) == 1) {
                    computer.shuffleNums();
                }
                if (Integer.parseInt(inputNum) == 2) {
                    break;
                }
            }
        }
    }

    private static Score getCompareResultWithInputNumberAndComputerNumber(String inputNumberStr,
                                                                          Computer computer) {
        Score score = new Score();
        for (int i = 0; i < inputNumberStr.length(); i++) {
            int inputNumberAt = Character.getNumericValue(inputNumberStr.charAt(i));
            if (computer.getNums().get(i) == inputNumberAt) {
                score.increaseStrikeCount();
            } else if (computer.getNums().contains(inputNumberAt)) {
                score.increaseBallCount();
            }
        }
        return score;
    }
}
