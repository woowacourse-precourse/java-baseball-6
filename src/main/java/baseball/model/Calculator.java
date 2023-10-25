package baseball.model;

import java.util.List;

public class Calculator {

    private Integer computerNumber1;

    private Integer computerNumber2;

    private Integer computerNumber3;

    private Integer guess1;

    private Integer guess2;

    private Integer guess3;

    // addComputerNumbers: 컴퓨터가 뽑은 3개의 숫자를 받는다.
    public void addComputerNumbers(Computer computer) {
        List<Integer> computerNumbers = computer.getNumberList();
        computerNumber1 = computerNumbers.get(0);
        computerNumber2 = computerNumbers.get(1);
        computerNumber3 = computerNumbers.get(2);
    }

    // addGuessNumbers: 유저가 추측한 3개의 숫자를 받는다.
    public void addGuessNumbers(Guess guess) {
        List<Integer> guessNumbers = guess.getNumberList();
        guess1 = guessNumbers.get(0);
        guess2 = guessNumbers.get(1);
        guess3 = guessNumbers.get(2);
    }

    // calcResult : 입력을 토대로 결과를 계산한다.
    public void calcResult(GuessResult guessResult) {
        if (computerNumber1.equals(guess1)) {
            guessResult.IncreaseStrike();
        } else if (computerNumber2.equals(guess1) || computerNumber3.equals(guess1)) {
            guessResult.IncreaseBall();
        }
        if (computerNumber2.equals(guess2)) {
            guessResult.IncreaseStrike();
        } else if (computerNumber1.equals(guess2) || computerNumber3.equals(guess2)) {
            guessResult.IncreaseBall();
        }
        if (computerNumber3.equals(guess3)) {
            guessResult.IncreaseStrike();
        } else if (computerNumber1.equals(guess3) || computerNumber2.equals(guess3)) {
            guessResult.IncreaseBall();
        }
    }

}
