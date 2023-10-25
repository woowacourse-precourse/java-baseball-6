package baseball.presentation;

import camp.nextstep.edu.missionutils.Console;


public class UserInput {

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        inputNumberExceptionHandler(input);
        return input;
    }

    public String inputRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        inputRestartNumberExceptionHandler(input);
        return input;
    }

    private void inputNumberExceptionHandler(String input) {
        if (input.chars().anyMatch(c -> !Character.isDigit((char) c))) {
            throw new IllegalArgumentException("입력값이 숫자여야 합니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자여야 합니다.");
        }
    }

    private void inputRestartNumberExceptionHandler(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
        }
    }
}
