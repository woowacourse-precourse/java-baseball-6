package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    private static void pickComputerNumber(List<Integer> computerNumber) {
        int randomNumber;
        while (computerNumber.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private static void playGame(List<Integer> computerNumber) throws IllegalArgumentException {
        String userInput = "";
        List<Integer> parsedUserInput = new ArrayList<>();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();
            if (userInput.length() != 3) {
                throw new IllegalArgumentException();
            }
            parseString(parsedUserInput, userInput);
            if (calc(parsedUserInput, computerNumber)) {
                return;
            }
            parsedUserInput.clear();
        }
    }

    private static boolean calc(List<Integer> input, List<Integer> computerNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == computerNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(input.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static void printResult(int strike, int ball) {
        String resultString = "";
        if (strike == 0 && ball == 0) {
            resultString = "낫싱";
        }
        if (ball != 0) {
            resultString += ball + "볼 ";
        }
        if (strike != 0) {
            resultString += strike + "스트라이크";
        }
        System.out.println(resultString);
    }

    private static void parseString(List<Integer> target, String str) throws IllegalArgumentException {
        try {
            for (int i = 0; i < str.length(); i++) {
                target.add(str.charAt(i) - '0');
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    }
}
