package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int RESTART = 1;
    public static final int END = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application.start();
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
            strikeCount += countUp(userInput.get(i), result.get(i));
        }
        return strikeCount;
    }

    public static int getBallCount(List<Integer> userInput, List<Integer> result) {
        int ballCount = 0;

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                ballCount += countUp(userInput.get(i), result.get(j));
            }
        }
        return ballCount;
    }

    public static int countUp(int userInput, int result) {
        if (userInput == result) {
            return 1;
        }
        return 0;
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

        if (isRightLength(userInput, 3) && isDigitNumber(userInput)
                && isRightRangeNumber(userInput) && isDifferentNumber(userInput)) {
            numberList = changeStringToList(userInput);
            return numberList;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static void outputBaseball(int strike, int ball) {
        if ((strike == 3)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if ((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
        } else if ((strike == 0) && (ball != 0)) {
            System.out.println(ball + "볼");
        } else if ((strike != 0) && (ball == 0)) {
            System.out.println(strike + "스트라이크");
        } else if ((strike != 0) && (ball != 0)) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static int inputStartOrEnd(String userInputStartOrEnd) {
        if (isRightLength(userInputStartOrEnd, 1)
                && isDigitNumber(userInputStartOrEnd)
                && isOneOrTwo(userInputStartOrEnd)) {
            return userInputStartOrEnd.charAt(0) - '0';
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static boolean isOneOrTwo(String userInputStartOrEnd) {
        int userInputNumber = userInputStartOrEnd.charAt(0) - '0';

        if ((userInputNumber == RESTART) || (userInputNumber == END)) {
            return true;
        }
        throw new IllegalArgumentException("입력이 1 또는 2가 아닌 잘못된 입력입니다.");
    }

    public static boolean isRightLength(String userInput, int inputLength) {
        if (userInput.length() == inputLength) {
            return true;
        }
        throw new IllegalArgumentException("입력 길이가 " + inputLength + "이 아닌 잘못된 입력입니다.");
    }

    public static int countDigitInString(String userInput) {
        int digitCount = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isDigit(userInput.charAt(i))) {
                digitCount++;
            }
        }
        return digitCount;
    }

    public static boolean isDigitNumber(String userInput) {
        int digitCount = countDigitInString(userInput);
        if ((digitCount == userInput.length())) {
            return true;
        }
        throw new IllegalArgumentException("입력에 숫자가 아닌 것이 포함된 잘못된 입력입니다.");
    }

    public static boolean isRightRangeNumber(String userInput) {
        int indexZero = userInput.charAt(0) - '0';
        int indexOne = userInput.charAt(1) - '0';
        int indexTwo = userInput.charAt(2) - '0';
        if ((1 <= indexZero && indexZero <= 9) && (1 <= indexOne && indexOne <= 9)
                && (1 <= indexTwo && indexTwo <= 9)) {
            return true;
        }
        throw new IllegalArgumentException("입력에 1~9사이 숫자가 아닌 숫자가 포함된 잘못된 입력입니다.");
    }

    public static boolean isDifferentNumber(String userInput) {
        int indexZero = userInput.charAt(0) - '0';
        int indexOne = userInput.charAt(1) - '0';
        int indexTwo = userInput.charAt(2) - '0';
        if ((indexZero != indexOne) && (indexOne != indexTwo)
                && (indexTwo != indexZero)) {
            return true;
        }
        throw new IllegalArgumentException("입력에 중복된 숫자가 포함된 잘못된 입력입니다.");
    }

    public static void outputOneGameBaseball(List<Integer> userInputList, List<Integer> result) {
        int strike = Application.getStrikeCount(userInputList, result);
        int ball = Application.getBallCount(userInputList, result);

        if ((strike != 0) && (ball != 0)) {
            ball -= strike;
        }

        outputBaseball(strike, ball);
    }

    public static boolean isEndGame(List<Integer> userInputList, List<Integer> result) {
        int strike = Application.getStrikeCount(userInputList, result);
        if (strike == 3) {
            return true;
        }
        return false;
    }

    public static void startOneGame(List<Integer> result) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            List<Integer> userInputList = Application.inputBaseball(userInput);
            outputOneGameBaseball(userInputList, result);
            if (isEndGame(userInputList, result)) {
                break;
            }
        }
    }

    public static int startGame() {
        List<Integer> result = Application.getThreeRandomNumber();
        Application.startOneGame(result);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInputStartOrEnd = Console.readLine();
        return Application.inputStartOrEnd(userInputStartOrEnd);
    }

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            int startOrEnd = Application.startGame();
            if (startOrEnd == RESTART) {
                continue;
            } else if (startOrEnd == END) {
                break;
            }
        }
    }

}
