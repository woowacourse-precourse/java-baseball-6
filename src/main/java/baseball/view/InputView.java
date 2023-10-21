package baseball.view;

import baseball.domain.ClientNumbers;
import baseball.exception.InputNeitherRestartNorExit;
import baseball.exception.InputNotNumber;
import baseball.exception.InputNumberNotUnique;
import baseball.exception.InputSizeNot3;

import java.util.Scanner;

public class InputView {
    private static final String ENTER_NUMBERS_MSG = "숫자를 입력해주세요 : ";
    private final int CLIENT_NUMBERS_SIZE = 3;

    public void printInputMsg() {
        System.out.print(ENTER_NUMBERS_MSG);
    }

    public ClientNumbers makeClientNumbers() {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        validateInputNotNumber(inputStr);
        validateInputNumberNotUnique(inputStr);
        validateInputSizeNot3(inputStr);

        int input = Integer.parseInt(inputStr);
        ClientNumbers clientNumbers = new ClientNumbers(CLIENT_NUMBERS_SIZE);

        while (input > 0) {
            clientNumbers.intArr.add(input % 10);
            input /= 10;
        }

        return clientNumbers;
    }

    // 사용자가 모든 숫자를 맞춘 이후에 검증해야 함
    public void validateInputNeitherRestartNorExit(String inputStr) {
        if (!inputStr.equals("1") || !inputStr.equals("2")) {
            throw new InputNeitherRestartNorExit();
        }
    }

    public void validateInputNotNumber(String inputStr) {
        char[] charArray = inputStr.toCharArray();

        for(char c : charArray) {
            if(!Character.isDigit(c)) {
                throw new InputNotNumber();
            }
        }
    }

    public void validateInputNumberNotUnique(String inputStr) {
        char[] charArray = inputStr.toCharArray();

        for(int i=1; i<=CLIENT_NUMBERS_SIZE; i++) {
            char firstChar = charArray[0];
            if(firstChar == charArray[i]) {
                throw new InputNumberNotUnique();
            }
        }
    }

    public void validateInputSizeNot3(String inputStr) {
        if (inputStr.length() != CLIENT_NUMBERS_SIZE) {
            throw new InputSizeNot3();
        }
    }

}
