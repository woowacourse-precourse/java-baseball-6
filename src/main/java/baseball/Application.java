package baseball;

import static baseball.view.Message.endMessage;
import static baseball.view.Message.inputMessage;
import static baseball.view.Message.replayMessage;
import static baseball.view.Message.resultMessage;
import static baseball.view.Message.startMessage;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.model.Result;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    static void playGame() {
        List<Integer> computerNumber = getRandomNumber();
        while (true) {
            inputMessage();
            String userNumber = inputUserNumber();
            Result result = compareNumber(userNumber, computerNumber);
            resultMessage(result.getBall(), result.getStrike());
            if (result.getStrike() == 3) {
                endMessage();
                break;
            }
        }
    }

    static Result compareNumber(String userNumber, List<Integer> computerNumber) {
        String[] number = userNumber.split("");
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(number[i]);
            if (computerNumber.get(i) == num) {
                strike++;
            } else if (computerNumber.contains(num)) {
                ball++;
            }
        }
        Result result = new Result(ball, strike);
        return result;
    }


    static List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static String inputUserNumber() {
        String input = readLine();
        checkUserInput(input);
        return input;
    }

    static void checkUserInput(String input) {
        HashSet<Character> numberBucket = new HashSet<>();
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            if (numberBucket.contains(input.charAt(i))) {
                throw new IllegalArgumentException();
            } else {
                numberBucket.add(input.charAt(i));
            }
        }
    }

    static boolean replayInputCheck() {
        replayMessage();
        String input = readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean replay = true;
        startMessage();
        while (replay) {
            playGame();
            replay = replayInputCheck();
        }
    }
}
