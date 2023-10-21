package baseball.view;

import baseball.domain.ClientNumbers;
import baseball.exception.InputExceedSize4;
import baseball.exception.InputNumberNotUnique;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ENTER_NUMBERS_MSG = "숫자를 입력해주세요 : ";
    private final int CLIENT_NUMBERS_SIZE = 3;

    private final Scanner scanner = new Scanner(System.in);

    public void printInputMsg() {
        System.out.print(ENTER_NUMBERS_MSG);
    }

    public ClientNumbers makeClientNumbers() {
        String inputStr = scanner.nextLine();

        int input = Integer.parseInt(inputStr);
        ClientNumbers clientNumbers = new ClientNumbers(CLIENT_NUMBERS_SIZE);

        while (input > 0) {
            clientNumbers.intArr.add(input % 10);
            input /= 10;
        }

        return clientNumbers;
    }
}
