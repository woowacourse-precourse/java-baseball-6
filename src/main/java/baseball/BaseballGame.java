package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.END_NUMBER;
import static baseball.Constant.MY_NUMBER_INPUT_LENGTH;

public class BaseballGame {

    private static BaseballGame baseballGame;

    private BaseballGame() {
    }

    private static BaseballGame getInstance() {
        if (baseballGame == null) {
            baseballGame = new BaseballGame();
        }
        return baseballGame;
    }

    public static void start() {
        getInstance().play();
    }

    public static boolean endCheck() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int input = InputChecker.checkAndMakeNumber(Console.readLine());

        if (input == END_NUMBER) {
            return true;
        }

        return false;
    }

    private void play() {
        List<Integer> computerNumber = setComputerNumber();

        Result result = new Result();
        while (!isMyNumberCorrect(result)) {
            List<Integer> myNumber = setMyNumber();

            result = compareNumber(computerNumber, myNumber);
            printResult(result);
        }
    }

    private List<Integer> setComputerNumber() {
        List<Integer> computer = new ArrayList<>(MY_NUMBER_INPUT_LENGTH);
        while (computer.size() < MY_NUMBER_INPUT_LENGTH) {
            checkDuplicationAndSetNumber(computer, Randoms.pickNumberInRange(1, 9));
        }

        return computer;
    }

    private void checkDuplicationAndSetNumber(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    private List<Integer> setMyNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return InputChecker.checkAndMakeList(input);
    }

    private Result compareNumber(List<Integer> computerNumber, List<Integer> myNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < MY_NUMBER_INPUT_LENGTH; i++) {
            for (int j = 0; j < MY_NUMBER_INPUT_LENGTH; j++) {
                if (computerNumber.get(i) == myNumber.get(j)) {
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }

        return new Result(ball, strike);
    }

    private void printResult(Result result) {
        int ball = result.getBall();
        int strike = result.getStrike();

        StringBuilder sb = new StringBuilder();

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        if (ball != 0) {
            sb.append(ball + "볼 ");
        }
        if (strike != 0) {
            sb.append(strike + "스트라이크");
        }

        System.out.println(sb);
    }

    private boolean isMyNumberCorrect(Result result) {
        if (result.getStrike() == MY_NUMBER_INPUT_LENGTH) {
            return true;
        }
        return false;
    }
}
