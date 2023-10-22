package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static final int DIGIT_SIZE = 3;
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static boolean terminated;
    static Computer computer;
    static User user;

    public static void main(String[] args) {
        startGame();
        while (!terminated) {
            computer.selectNumbers();
            playGame();
            terminated = selectTerminate();
        }
    }

    static void startGame() {
        System.out.println(START_MESSAGE);
        user = new User();
        computer = new Computer();
    }

    static void playGame() {
        boolean matched = false;
        while (!matched) {
            user.selectNumbers();
            Result result = testMatch();
            result.print();
            matched = result.isMatched();
        }
        System.out.println(GAME_OVER_MESSAGE);
    }

    static Result testMatch() {
        int strike = 0;
        int nothing = 0;
        for (int index = 0; index < DIGIT_SIZE; index++) {
            BaseballNumber userNumber = user.numberOf(index);
            strike += computer.testStrike(index, userNumber);
            nothing += computer.testNothing(userNumber);
        }
        int ball = 3 - strike - nothing;
        return new Result(strike, ball, nothing);
    }

    static boolean selectTerminate() {
        System.out.println(REGAME_MESSAGE);
        try {
            String input = Console.readLine();
            int code = Integer.parseInt(input);
            validateCode(code);
            return (code == 2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return true;
    }

    private static void validateCode(int code) {
        if (code != 1 && code != 2) {
            throw new IllegalArgumentException();
        }
    }
}
