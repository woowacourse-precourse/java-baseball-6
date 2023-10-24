package baseball.model;

import baseball.model.numberstrategy.UserInputNumberSelectionStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 모든_숫자가_같으면_isThreeStrikes가_true() {
        //given
        Numbers answerNumbers = Numbers.createNumbersFrom(new UserInputNumberSelectionStrategy("123"));
        Numbers guessNumbers = Numbers.createNumbersFrom(new UserInputNumberSelectionStrategy("123"));

        //when
        GameResult result = answerNumbers.calculateResult(guessNumbers);

        //then
        Assertions.assertThat(result.isThreeStrikes()).isTrue();
    }

    @Test
    void 같은_자리에_같은_수가_있으면_스트라이크() {
        //given
        Numbers answerNumbers = Numbers.createNumbersFrom(new UserInputNumberSelectionStrategy("123"));
        Numbers guessNumbers = Numbers.createNumbersFrom(new UserInputNumberSelectionStrategy("156"));

        //when
        GameResult result = answerNumbers.calculateResult(guessNumbers);

        //then
        Assertions.assertThat(result.strike()).isEqualTo(1);
    }

    @Test
    void 다른_자리에_같은_수가_있으면_볼() {
        //given
        Numbers answerNumbers = Numbers.createNumbersFrom(new UserInputNumberSelectionStrategy("267"));
        Numbers guessNumbers = Numbers.createNumbersFrom(new UserInputNumberSelectionStrategy("156"));

        //when
        GameResult result = answerNumbers.calculateResult(guessNumbers);

        //then
        Assertions.assertThat(result.ball()).isEqualTo(1);
    }

}