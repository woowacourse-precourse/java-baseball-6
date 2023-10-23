package baseball;

import java.util.List;

/**
 * The class which controls a flow of game.
 * After a game end, the GameController is no more in use.
 */
public class GameController {
    private Numbers targetNumber;
    private InputAdapter inputAdapter;

    public GameController(Numbers targetNumber, InputAdapter inputAdapter) {
        this.targetNumber = targetNumber;
        this.inputAdapter = inputAdapter;
    }

    /**
     * @return true if the user decided to play one more game, otherwise false.
     */
    public boolean gameLoop() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            Numbers guess = this.inputAdapter.readNumber();
            StepResult result = check(guess);
            System.out.println(result);
            if (result.getNumOfStrike() >= 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return this.inputAdapter.readControlFlow();
    }

    private StepResult check(Numbers guess) {
        int strike = 0;
        int ball = 0;
        List<Integer> guessNumbers = guess.allNumbers();
        List<Integer> targetNumbers = targetNumber.allNumbers();
        for (int i = 0; i < guessNumbers.size(); i++) {
            int g = guessNumbers.get(i);
            strike += (equals(g, targetNumbers.get(i)))
                    ? 1
                    : 0;
            int targetNumbersSize = targetNumbers.size();
            ball += (equals(g, targetNumbers.get((i + 1) % targetNumbersSize))
                    || equals(g, targetNumbers.get((i + 2) % targetNumbersSize)))
                    ? 1
                    : 0;
        }
        return new StepResult(ball, strike);
    }

    private boolean equals(int num1, int num2) {
        return num1 == num2;
    }
}
