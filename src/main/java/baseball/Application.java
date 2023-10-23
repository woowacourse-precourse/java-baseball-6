package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static java.lang.Integer.*;

public class Application {
    public static void main(String[] args) {

        startGame();

        int computerNumber = generateComputerNumber();
        System.out.println("computerNumber = " + computerNumber);

        // userInput이 0인 경우 프로그램을 종료하도록 수정해야 한다.
        int userInput = getUserInput();
        System.out.println("userInput = " + userInput);

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

    private static void printHint(int num) {
        // 사용자 입력에 따른 힌트 출력
    }

    private static int getOptionNumber(String userInput) {
        // 게임을 계속하는 것과 관련해서 1과 2가 아닌 수를 입력 받을 시 exception 발생
        return 0;
    }

    private static boolean continueOrQuit(int optionNumber) {
        // getOptionNumber로 검증한 숫자를 받아서 게임을 지속할지 중단할지 결정
        return true;
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
