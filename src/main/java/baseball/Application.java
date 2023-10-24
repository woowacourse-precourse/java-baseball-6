package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static java.lang.Integer.*;

public class Application {

    public static boolean is3Strike = false;

    public static void main(String[] args) {

        startGame();
        int computerNumber = generateComputerNumber();
        System.out.println("computerNumber = " + computerNumber);

        while (true) {
            // 게임에서 3스트라이크를 했을 때 수행
            if (is3Strike) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                String optionString = readLine();
                int optionNumber = getOptionNumber(optionString);
                if (optionNumber == 1) {
                    computerNumber = generateComputerNumber();
                    is3Strike = false;
                    System.out.println("computerNumber = " + computerNumber);
                } else {
                    // getOptionNumber로 이미 검증을 거친 상태이기 때문에 넘어올 수 있는 수는 1과 2 둘 중 하나이다.
                    break;
                }
            }
            // 게임에서 아직 3스트라이크를 달성하지 못한 경우
            // userInput이 0인 경우 프로그램을 종료하도록 수정해야 한다.
            int userNumber = getUserInput();
            printHint(computerNumber,userNumber);
        }

    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static int generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                sb.append(randomNumber);
            }
        }
        return parseInt(sb.toString());
    }

    private static int getUserInput() {
        int validateNumber = 0;

        System.out.print("숫자를 입력해주세요 : ");
        String userInputString = readLine();

        try {
            validateNumber = isValidateNumber(userInputString);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return validateNumber;
    }

    private static int isValidateNumber(String userInput){
        int inputNumber;

        // Integer.parseInt가 되지 않는 경우
        try {
            inputNumber = parseInt(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("정수가 아닌 문자열입니다.");
        }

        // 3자리 숫자가 아닌 경우 예외 발생
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        // 사용자의 입력에 0이 포함된 경우 예외 발생
        if (userInput.contains("0")) {
            throw new IllegalArgumentException("0이 포함되어 있으면 안됩니다.");
        }

        // 사용자의 입력에 중복된 숫자가 포함된 경우 예외 발생
        if (isDuplicate(userInput)) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있으면 안됩니다.");
        }

        return inputNumber;
    }

    /**
     * 스트라이크의 개수와 볼의 개수가 같으면 스트라이크의 개수를 출력하고, 볼은 0으로 처리해야 한다.
     * 3스트라이크가 나오면 게임이 종료된다.
     * @param computerNumber
     * @param userNumber
     */
    private static void printHint(int computerNumber, int userNumber) {

        if (computerNumber - userNumber == 0) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            is3Strike = true;
            return;
        }

        int strike = countStrike(computerNumber, userNumber);
        int ball = countBall(computerNumber, userNumber);

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);

    }

    /**
     * 스트라이크 개수를 반환한다.
     * @param computerNumber
     * @param userNumber
     * @return count
     */
    private static int countStrike(int computerNumber, int userNumber) {
        String computerValue = String.valueOf(computerNumber);
        String userValue = String.valueOf(userNumber);
        int count = 0;

        for (int i = 0; i < computerValue.length(); i++) {
            if (computerValue.charAt(i) == userValue.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 볼의 개수를 반환한다.
     * @param computerNumber
     * @param userNumber
     * @return count
     */
    private static int countBall(int computerNumber, int userNumber) {
        String[] computerValue = String.valueOf(computerNumber).split("");
        String[] userValue = String.valueOf(userNumber).split("");

        /*HashSet<String> computerSet = new HashSet<>();
        int count = 0;

        for (String character : computerValue) {
            computerSet.add(character);
        }

        for (String character : userValue) {
            if (computerSet.contains(character)) {
                count++;
            }
        }*/
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (computerValue[i].equals(userValue[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int getOptionNumber(String userInput) {
        // 게임을 계속하는 것과 관련해서 1과 2가 아닌 수를 입력 받을 시 exception 발생
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("숫자 1 또는 2만 입력할 수 있습니다.");
        }
        return parseInt(userInput);
    }

    /**
     * 사용자가 입력한 문자열 안에 중복된 숫자가 있는지 검사한다.
     * set은 중복을 허용하지 않기 때문에 중복된 숫자가 있다면,
     * 처음 입력받은 userInput과 charSet의 길이가 다를 것이다.
     * @param userInput
     * @return charSet.size() != userInput.length()
     */
    private static boolean isDuplicate(String userInput) {
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            charSet.add(userInput.charAt(i));
        }
        return charSet.size() != userInput.length();    // 길이가 달라야 중복인 것.
    }
}
