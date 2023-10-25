package baseball.view.part;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.BDDMockito.given;

import baseball.scenario.Scenario.ScenarioResultType;
import baseball.view.core.InputView;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RetryGameViewTest {

    private final InputView inputView = Mockito.mock(InputView.class);
    private final RetryGameView retryGameView = new RetryGameView(inputView);

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 3, 4})
    void _1과_2를_제외한_숫자가_입력_될_경우_오류가_발생합니다(int command) {
        //given
        given(inputView.readRetryCommand()).willReturn(command);

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(retryGameView::execute);
    }

    @Test
    void _1을_입력하면_이전_단계로_이동합니다() {
        //given
        given(inputView.readRetryCommand()).willReturn(1);

        //then
        assertThat(retryGameView.execute()).isEqualTo(ScenarioResultType.PREVIOUS);
    }

    @Test
    void _2을_입력하면_다음_단계로_이동합니다() {
        //given
        given(inputView.readRetryCommand()).willReturn(2);

        //then
        assertThat(retryGameView.execute()).isEqualTo(ScenarioResultType.NEXT);
    }

}