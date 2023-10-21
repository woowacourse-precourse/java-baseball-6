package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static class Result {
        String message;
        boolean isContinue;

        Result(String message, boolean isContinue) {
            this.message = message;
            this.isContinue = isContinue;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        repeatGame();
    }

    public static void repeatGame() {
        boolean isContinue = true;
        int inputLength = 1;

        List<Integer> computer;
        List<Integer> user;

        String gameStartMessage = "숫자 야구 게임을 시작합니다.\n";
        String continueOrEndMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

        while (isContinue) {
            output(gameStartMessage);

            computer = generateRandomNumber();

            repeatRound(computer);

            output(continueOrEndMessage);

            user = input(inputLength);

            if (user.get(0) == 2) {
                isContinue = false;
            }
        }
    }

    public static void repeatRound(List<Integer> computer) {
        boolean isContinue = true;
        int inputLength = 3;

        List<Integer> user;

        Result result;

        String numberInputRequestMessage = "숫자를 입력해주세요 : ";

        while (isContinue) {
            output(numberInputRequestMessage);

            user = input(inputLength);

            result = compareTwoNumber(computer, user);

            output(result.message);

            isContinue = result.isContinue;
        }
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static Result compareTwoNumber(List<Integer> computer, List<Integer> user) {
        Result result;
        String message = "";
        boolean isContinue = true;

        int ball = 0;
        int strike = 0;

        for (int userIndex = 0; userIndex < user.size(); userIndex++) {
            int userNumber = user.get(userIndex);
            for (int computerIndex = 0; computerIndex < computer.size(); computerIndex++) {
                int computerNumber = computer.get(computerIndex);
                if (userNumber == computerNumber && userIndex != computerIndex) {
                    ball++;
                } else if (userNumber == computerNumber && userIndex == computerIndex) {
                    strike++;
                }
            }
        }

        if (ball == 0 && strike == 0) {
            message = "낫싱";
        }

        if (ball != 0) {
            message = message.concat(ball + "볼 ");
        }

        if (strike != 0) {
            message = message.concat(strike + "스트라이크");
        }

        if (ball == 0 && strike == 3) {
            message = message.concat("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isContinue = false;
        }

        result = new Result(message.trim(), isContinue);

        return result;
    }

    public static List<Integer> input(int inputLength) {
        List<Integer> user = new ArrayList<>();
        return user;
    }

    public static void output(String outputMessage) {
        System.out.print(outputMessage);
    }
}
