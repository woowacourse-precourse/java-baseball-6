package baseball;

import static baseball.Constant.END_NUMBER;
import static baseball.Constant.NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static void play() {
        getInstance().playing();
    }

    private void playing() {
        List<Integer> computerNumber = setComputerNumber();

        Result result;
        do {
            List<Integer> userNumber = setUserNumber();
            result = compareNumber(computerNumber, userNumber);
            result.print();
        } while (!result.isCorrect());
    }

    private List<Integer> setComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>(NUMBER_LENGTH);
        while (computerNumber.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }

    private List<Integer> setUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        InputChecker.checkUserNumber(input);

        return Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private Result compareNumber(List<Integer> computerNumber, List<Integer> userNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            for (int j = 0; j < NUMBER_LENGTH; j++) {
                if (computerNumber.get(i) == userNumber.get(j)) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        return new Result(ball, strike);
    }

    public static boolean checkGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        InputChecker.checkRestartNumber(input);

        if (input.equals(END_NUMBER)) {
            return true;
        }

        return false;
    }
}
