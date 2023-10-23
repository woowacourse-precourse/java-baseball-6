package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private final String ANSWERMESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

    public String getPlayerInput() {
        String input = Console.readLine();
        validatePlayNumber(input);

        return input;
    }

    public int gameContinue() {
        String input = Console.readLine();
        validateGameContinue(input);

        return Integer.parseInt(input);
    }

    public void showResult(int strike, int ball) {
        if(strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
            if(strike == 3) {
                System.out.println(ANSWERMESSAGE);
            }
        }

        else if(strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }

        else if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private void validatePlayNumber(String input) {
        if (!isInteger(input) || !isThreeDigit(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private void validateGameContinue(String input) {
        if (!isInteger(input) || !isOneOrTwo(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private boolean isInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력값입니다.");
        }
        return false;
    }

    private boolean isThreeDigit(String input) {
        int number = Integer.parseInt(input);
        return number >= 100 && number <= 999;
    }

    private boolean isOneOrTwo(String input) {
        int number = Integer.parseInt(input);
        return number == 1 || number == 2;
    }
}
