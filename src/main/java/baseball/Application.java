package baseball;

import baseball.View.InputView;
import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.displayGameStartMessage();
        boolean continueGame = true;

        while (continueGame) {
            List<Integer> computerNumbers = generateRandomNumbers();
            outputView.displayComputerNumbers(computerNumbers);

            boolean isGameWon = playGame(computerNumbers, inputView, outputView);

            outputView.displayGameEndMessage(isGameWon);

            continueGame = inputView.readRestartNumber();
        }

        outputView.displayGameExitMessage();
    }


    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    private static boolean playGame(List<Integer> computerNumbers, InputView inputView, OutputView outputView) {
        while (true) {
            List<Integer> playerNumbers = inputView.readNumbers();
            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                    strikes++;
                } else if (playerNumbers.contains(computerNumbers.get(i))) {
                    balls++;
                }
            }

            printResult(balls, strikes);

            if (strikes == 3) {
                return true;
            }
        }
    }

    private static void printResult(int balls, int strikes) {

        StringBuilder resultMessage = new StringBuilder();

        if (balls > 0) {
            resultMessage.append(balls + "볼 ");
        }

        if (strikes > 0) {
            resultMessage.append(strikes + "스트라이크 ");
        }

        if (strikes == 0 && balls == 0) {
            resultMessage.append("낫싱");
        }

        System.out.println(resultMessage.toString());
    }

}