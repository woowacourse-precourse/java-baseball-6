package baseball.service;

import static baseball.validation.InputNumberValidation.userInputNumberValidation;
import static baseball.validation.InputNumberValidation.validateParsedChar;

import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameService {
    private static boolean endOrNot = true;

    public static void startGame() {
        initStartGame();
        while (endOrNot) {
            startOneGame();
            exitGame();
        }
        System.out.println("게임 종료");
    }

    public static void startOneGame() {
        Computer computer = new Computer();
        boolean oneGameFinished = false;
        List<Integer> computerNumber = computer.getComputerNumber();
        while (!oneGameFinished) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = parsingInputNumber(InputView.Input());
            List<Integer> gameResult = playGame(computerNumber, userNumber);
            if (OutputView.outputResult(gameResult)) {
                oneGameFinished = true;
            }
        }
    }

    public static List<Integer> parsingInputNumber(String inputNumber) {
        ArrayList<Integer> parsingNumber = new ArrayList<>();
        userInputNumberValidation(inputNumber);
        for (char parsedChar : inputNumber.toCharArray()) {
            validateParsedChar(parsedChar);
            parsingNumber.add(Character.getNumericValue(parsedChar));
        }
        return parsingNumber;
    }


    public static void exitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (InputView.Input().equals("2")) {
            endOrNot = false;
        }
    }

    public static List<Integer> playGame(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = getStrikeCount(computerNumber, userNumber);
        int ball = getBallCount(computerNumber, userNumber);

        return List.of(strike, ball);
    }

    public static int getStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0, 3)
                .filter(i -> computerNumber.get(i).equals(userNumber.get(i)))
                .count();
    }

    public static int getBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0, 3)
                .filter(i -> !computerNumber.get(i).equals(userNumber.get(i)) && userNumber.contains(
                        computerNumber.get(i)))
                .count();
    }

    public static void initStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        endOrNot = true;
    }
}