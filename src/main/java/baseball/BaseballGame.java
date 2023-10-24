package baseball;

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
        InputValidation.checkUserNumber(input);

        return Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private Result compareNumber(List<Integer> computerNumber, List<Integer> userNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
                continue;
            }

            if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }

        return new Result(ball, strike);
    }
}
