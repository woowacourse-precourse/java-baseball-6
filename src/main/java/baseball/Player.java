package baseball;

import camp.nextstep.edu.missionutils.Console;

class Player {
    private Console console;

    public Player() {
    }

    public int inputGuess() {
        int guess = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.printf("3자리 숫자를 입력하세요: ");
            String input = console.readLine();
            if (input.length() != 3 || !input.matches("\\d{3}")) {
                System.out.println("올바른 3자리 숫자를 입력하세요.");
            } else {
                guess = Integer.parseInt(input);
                validInput = true;
            }
        }
        return guess;
    }

    public void displayResult(String result) {
        System.out.println(result);
    }

    public boolean playAgain() {
        System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String choice = console.readLine();
        return "1".equals(choice);
    }
}