package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game implements Rule {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private boolean terminated;
    private Computer computer;
    private User user;

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void play() {
        System.out.println(START_MESSAGE);
        while (!terminated) {
            computer.selectNumbers();
            guessNumber();
            terminated = selectTerminate();
        }
    }

    private void guessNumber() {
        boolean matched = false;
        while (!matched) {
            user.selectNumbers();
            Result result = testMatch();
            result.print();
            matched = result.isMatched();
        }
        System.out.println(GAME_OVER_MESSAGE);
    }

    private Result testMatch() {
        int strike = 0;
        int nothing = 0;
        for (int index = 0; index < DIGIT_SIZE; index++) {
            BaseballNumber userNumber = user.numberOf(index);
            strike += computer.testStrike(index, userNumber);
            nothing += computer.testNothing(userNumber);
        }
        int ball = DIGIT_SIZE - strike - nothing;
        return new Result(strike, ball, nothing);
    }

    private boolean selectTerminate() {
        System.out.println(REGAME_MESSAGE);
        String input = Console.readLine();
        int code = Integer.parseInt(input);
        validateCode(code);
        return (code == 2);
    }

    private void validateCode(int code) {
        if (code != 1 && code != 2) {
            throw new IllegalArgumentException();
        }
    }
}
