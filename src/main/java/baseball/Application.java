package baseball;

import baseball.View.inputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean continueGame = true;

        inputView view = new inputView();

        while (continueGame) {
            List<Integer> computerNumbers = generateRandomNumbers();
            System.out.println("컴퓨터 숫자: " + computerNumbers);

            boolean isGameWon = playGame(computerNumbers, view);

            if (isGameWon) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else {
                System.out.println("게임 종료");
            }

            continueGame = view.readRestartNumber();
        }

        System.out.println("게임을 종료합니다.");
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

    private static boolean playGame(List<Integer> computerNumbers, inputView view) {
        while (true) {
            List<Integer> playerNumbers = view.readNumbers();
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