package baseball.User.Input;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class UserInput {
    public String getGamingInput() {
        String userInput;

        System.out.print("숫자를 입력해주세요 : ");
        userInput = removeSpace(Console.readLine());

        validateGetGamingInput(userInput);

        return userInput;
    }

    public String getEndGameInput() {
        String userInput;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userInput = removeSpace(Console.readLine());

        validateGetEndGameInput(userInput);

        return userInput;
    }

    private String removeSpace(String str) {
        return str.replace(" ", "");
    }

    private void validateGetGamingInput(String input) {
        checkThreeNumber(input);
        checkOnlyCompositionNumber(input);
        checkDuplicationNumber(input);
    }

    private void validateGetEndGameInput(String input) {
        checkOnlyTwoNumber(input);
    }

    private void checkThreeNumber(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("세 개의 숫자를 입력해야 합니다.");
        }
    }

    private void checkOnlyCompositionNumber(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("입력된 값은 1~9 사이의 숫자만 가능합니다.");
            }
        }
    }

    private void checkDuplicationNumber(String input){
        Set<Character> uniqueNumbers = new HashSet<>();

        for (char c : input.toCharArray()) {
            if(uniqueNumbers.contains(c)){
                throw new IllegalArgumentException("입력된 숫자에 중복된 값이 있습니다.");
            }
            uniqueNumbers.add(c);
        }
    }

    private void checkOnlyTwoNumber(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
