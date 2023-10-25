package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readGuess() {
        String guess = readLine();
        validateNumberString(guess);

        return guess;
    }

    public String readRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String command = readGuess();
        validateNumberString(command);

        return command;
    }

    private void validateNumberString(String guess) {
        if (!guess.matches("^[0-9]*$")) {
            throw new NotNumberStringException();
        }
    }

    private String readLine() {
        return Console.readLine().replaceAll(" ", "");
    }

    public static class NotNumberStringException extends IllegalAccessError {
    }


}
