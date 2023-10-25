package baseball.collaborator.number;

import baseball.collaborator.generic.BallCount;
import baseball.collaborator.number.generator.FakeNumbersGenerator;
import baseball.collaborator.number.generator.OneTwoThreeNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 야구숫자와_정답숫자가_모두_정확히_일치할때_ballCounting_결과는_3스트라이크() {
        OneTwoThreeNumbersGenerator fakeGenerator = new OneTwoThreeNumbersGenerator();
        BaseballNumbers baseballNumbers = new BaseballNumbers(fakeGenerator);
        String expected = "3스트라이크";

        WinningNumbers winningNumbers = new WinningNumbers(fakeGenerator);
        BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

        Assertions.assertThat(ballCount.toString()).isEqualTo(expected);
    }

    @Test
    void 야구숫자와_정답숫자가_1개_정확히_일치할때_ballCounting_결과는_1스트라이크() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(new FakeNumbersGenerator(1,5,6));
        String expected = "1스트라이크";

        WinningNumbers winningNumbers = new WinningNumbers(new OneTwoThreeNumbersGenerator());
        BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

        Assertions.assertThat(ballCount.toString()).isEqualTo(expected);
    }

    @Test
    void 야구숫자와_정답숫자가_1개_일치할때_ballCounting_결과는_1볼() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(new FakeNumbersGenerator(5,6, 1));
        String expected = "1볼";

        WinningNumbers winningNumbers = new WinningNumbers(new OneTwoThreeNumbersGenerator());
        BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

        Assertions.assertThat(ballCount.toString()).isEqualTo(expected);
    }

    @Test
    void 야구숫자와_정답숫자가_1개_정확히_일치하고_1개_일치할때_ballCounting_결과는_1볼_1스트라이크() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(new FakeNumbersGenerator(5,2, 1));
        String expected = "1볼 1스트라이크";

        WinningNumbers winningNumbers = new WinningNumbers(new OneTwoThreeNumbersGenerator());
        BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

        Assertions.assertThat(ballCount.toString()).isEqualTo(expected);
    }

}