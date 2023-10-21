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
        Result result = null;
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
