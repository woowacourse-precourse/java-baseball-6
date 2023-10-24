package baseball.view.part;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import baseball.event.EventContext;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("컴퓨터_초기화_view에서")
class InitializeComputerViewTest {

    @Nested
    @DisplayName(" 컴퓨터 초기화 이벤트를 진행할 때")
    class EventTest {


        @RepeatedTest(100)
        @Test
        void _랜덤한_숫자로_정상적으로_초기화_됩니다() {
            final var eventContext = new EventContext();
            //when
            new InitializeComputerView.InitializeComputerEvent(eventContext).execute();
            final var computerNumbers = eventContext.getComputer().numbers();

            //then
            assertAll(
                    () -> assertThat(computerNumbers.size()).isEqualTo(3),
                    () -> computerNumbers.forEach(i -> assertThat(i).isBetween(1, 9)),
                    () -> assertThat(new HashSet<>(computerNumbers)).size().isEqualTo(3)
            );


        }

    }

}