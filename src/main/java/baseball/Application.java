package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getThreeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int getStrikeCount(List<Integer> userInput, List<Integer> result) {
        int strikeCount = 0;

        for (int i = 0; i < result.size(); i++) {
            if (userInput.get(i) == result.get(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static int getBallCount(List<Integer> userInput, List<Integer> result) {
        int ballCount = 0;

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                if (userInput.get(i) == result.get(j)) {
                    ballCount++;
                }
            }
        }

        return ballCount;
    }

    public static List<Integer> changeStringToList(String userInput) {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            int charToInt = userInput.charAt(i) - '0';
            numberList.add(charToInt);
        }

        return numberList;
    }

    public static List<Integer> inputBaseball(String userInput) {
        List<Integer> numberList = new ArrayList<>();

        if (isLengthThree(userInput)
                && isDigitNumber(userInput)
                && isRightRangeNumber(userInput)
                && isDifferentNumber(userInput)) {
            numberList = changeStringToList(userInput);
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return numberList;
    }

    public static void outputBaseball(int strike, int ball) {
        if ((strike == 3) && (ball == 3)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if ((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static boolean isLengthThree(String userInput) {
        if (userInput.length() == 3) {
            return true;
        } else {
            throw new IllegalArgumentException("입력 길이가 3이 아닌 잘못된 입력입니다.");
        }
    }

    public static boolean isDigitNumber(String userInput) {
        int digitCount = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isDigit(userInput.charAt(i))) {
                digitCount++;
            }
        }

        if ((digitCount == userInput.length())) {
            return true;
        } else {
            throw new IllegalArgumentException("입력에 숫자가 아닌 것이 포함된 잘못된 입력입니다.");
        }
    }

    public static boolean isRightRangeNumber(String userInput) {
        int indexZero = userInput.charAt(0) - '0';
        int indexOne = userInput.charAt(1) - '0';
        int indexTwo = userInput.charAt(2) - '0';

        if ((1 <= indexZero && indexZero <= 9)
                && (1 <= indexOne && indexOne <= 9)
                && (1 <= indexTwo && indexTwo <= 9)) {
            return true;
        } else {
            throw new IllegalArgumentException("입력에 1~9사이 숫자가 아닌 숫자가 포함된 잘못된 입력입니다.");
        }
    }

    public static boolean isDifferentNumber(String userInput) {
        int indexZero = userInput.charAt(0) - '0';
        int indexOne = userInput.charAt(1) - '0';
        int indexTwo = userInput.charAt(2) - '0';

        if ((indexZero != indexOne)
                && (indexOne != indexTwo)
                && (indexTwo != indexZero)) {
            return true;
        } else {
            throw new IllegalArgumentException("입력에 중복된 숫자가 포함된 잘못된 입력입니다.");
        }
    }

    public void startOneGame(List<Integer> result) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            List<Integer> userInputList = Application.inputBaseball(userInput);

            int strike = Application.getStrikeCount(userInputList, result);
            int ball = Application.getBallCount(userInputList, result);

            outputBaseball(strike, ball);

            if (strike == 3) {
                break;
            }
        }
    }

}
