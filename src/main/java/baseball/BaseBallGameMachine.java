package baseball;

import baseball.io.Input;
import baseball.io.Output;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseBallGameMachine {

    private final Input input = new Input();
    private final Output output = new Output();
    private List<Integer> computerNumbers;
    private boolean flag = true;

    public void run() {
        output.printStartMessage();

        makeRandomNumbers();

        while (flag) {
            List<Integer> userNumbersInput = userInput();

            printHint(calculation(userNumbersInput));
        }

        finishOrRestart();
    }


    public void makeRandomNumbers() {

        computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }



    public List<Integer> userInput() {
        output.printRequestUserNumberInput();
        return input.userNumberInput();
    }

    public int[] calculation(List<Integer> userInput) {
        int ball = countBall(userInput);
        int strike = countStrike(userInput);

        if (strike == 3) {
            flag = false;
        }

        return new int[]{ball, strike};
    }

    public int countBall(List<Integer> userInput) {
        int ball = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (!Objects.equals(userInput.get(i), computerNumbers.get(i)) && computerNumbers.contains(userInput.get(i))) {
                ball++;
            }
        }

        return ball;
    }

    public int countStrike(List<Integer> userInput) {
        int strike = 0;

        for (int i = 0; i < userInput.size(); i++) {
            if (Objects.equals(userInput.get(i), computerNumbers.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    public void printHint(int[] calculation) {
        output.printHint(calculation);
    }

    public void finishOrRestart() {
        output.printFinishOrRestart();
        String finishOrRestartInput = input.finishOrRestartInput();

        if (finishOrRestartInput.equals("1")) {
            flag = true;
            run();
        }
    }


}
