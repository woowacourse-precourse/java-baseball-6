package baseball;

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
        if (guess.firstNumber() == targetNumber.firstNumber()) {
            strike++;
        }
        if (guess.secondNumber() == targetNumber.secondNumber()) {
            strike++;
        }
        if (guess.thirdNumber() == targetNumber.thirdNumber()) {
            strike++;
        }
        if (guess.firstNumber() == targetNumber.secondNumber()
                || guess.firstNumber() == targetNumber.thirdNumber()) {
            ball++;
        }
        if (guess.secondNumber() == targetNumber.firstNumber()
                || guess.secondNumber() == targetNumber.thirdNumber()) {
            ball++;
        }
        if (guess.thirdNumber() == targetNumber.secondNumber()
                || guess.thirdNumber() == targetNumber.firstNumber()) {
            ball++;
        }
        return new StepResult(ball, strike);
    }
}
