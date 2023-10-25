package baseball.view;

import baseball.model.Calculator;
import baseball.model.Computer;
import baseball.model.Guess;
import baseball.model.GuessResult;
import camp.nextstep.edu.missionutils.Console;

public class GameView {

    private final Computer computer;

    private final Calculator calculator;

    public GameView(Computer computer, Calculator calculator) {
        this.computer = computer;
        this.calculator = calculator;
    }

    // setNewGame : 새로운 게임을 설정한다.
    public void setNewGame() {
        computer.initComputerNumbers();
        calculator.addComputerNumbers(computer);
    }

    // doGame : 정해진 루틴에 따라 게임을 진행한다.
    public void doGame() throws IllegalArgumentException {
        Guess guess = new Guess();
        GuessResult guessResult = new GuessResult();
        guess.waitUserGuess();
        calculator.addGuessNumbers(guess);
        calculator.calcResult(guessResult);
        guessResult.printHint();
        if (guessResult.is3Strike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        doGame();
    }

    // askContinue : 유저에게 다음 게임을 시작할지 여부를 형식에 따라 입력받는다.
    public Boolean askContinue() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        Integer input;
        try {
            input = Integer.valueOf(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be Integer type");
        }
        if (input.equals(1)) {
            return true;
        } else if (input.equals(2)) {
            return false;
        }
        throw new IllegalArgumentException("Input must be 1 or 2");
    }

}
