package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public void run() {
        do {
            play();
        } while (inputRegame());
    }

    private void play() {
        int strike = 0;
        List<Integer> rivalNumber;
        List<Integer> userGuessNumber;
        int[] result;

        printStartMessage();
        rivalNumber = makeRivalNumber();
        System.out.println(rivalNumber);

        while (strike != 3) {
            userGuessNumber = inputUserGuess();
            result = checkScore(rivalNumber, userGuessNumber);
            printResult(result);
            strike = result[0];
        }

        printFinishMessage();
    }

    private void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printFinishMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Integer> makeRivalNumber() {
        List<Integer> rivalNumber = new ArrayList<>();

        while (rivalNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!rivalNumber.contains(randomNumber)) {
                rivalNumber.add(randomNumber);
            }
        }
        return rivalNumber;
    }

    private List<Integer> inputUserGuess() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        if (input.length() > 3) {
            throw new IllegalArgumentException();
        }
        return toArrayList(input);
    }

    private List<Integer> toArrayList(String input) {
        List<Integer> userGuessNumber = new ArrayList<>();

        for (String number : input.split("")) {
            userGuessNumber.add(Integer.parseInt(number));
        }
        return userGuessNumber;
    }

    private int[] checkScore(List<Integer> rivalNumber, List<Integer> userGuessNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < rivalNumber.size(); i++) {
            if (rivalNumber.get(i).equals(userGuessNumber.get(i))) {
                strike++;
            } else if (userGuessNumber.contains(rivalNumber.get(i))) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }

    private void printResult(int[] result) {
        if (result[0] >= 1 && result[1] >= 1) {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        } else if (result[0] >= 1 && result[1] == 0) {
            System.out.println(result[0] + "스트라이크");
        } else if (result[0] == 0 && result[1] >= 1) {
            System.out.println(result[1] + "볼");
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }
    }

    private boolean inputRegame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}