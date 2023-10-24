package baseball.game;

import java.util.Scanner;

public class Game {
    private Inning inning;

    public Game() {
        inning = null;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void startGame() {
        inning = new Inning();
        inning.startInning();
    }

    public boolean checkRestart() {
        if (inning == null) {
            return true;
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = inputNumber();

        int inputNumber = convertToNumber(input);
        validateInput(inputNumber);

        return isRestart(inputNumber);
    }

    private boolean isRestart(int inputNumber) {
        if (inputNumber == 1) {
            return true;
        }
        return false;
    }

    private String inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void validateInput(int inputNumber) {
        if (inputNumber != 1 && inputNumber != 2) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    private int convertToNumber(String obj) {
        try {
            int parsedNumber = Integer.parseInt(obj);

            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}
