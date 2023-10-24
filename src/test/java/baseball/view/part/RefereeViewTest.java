package baseball.view.part;

import static org.mockito.BDDMockito.given;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.event.EventContext;
import baseball.view.part.RefereeView.RefereeEvent;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


@DisplayName("RefreeView에서")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RefereeViewTest {


    @Nested
    @DisplayName(" 이벤트 테스트에서")
    class EventTest {

        @Test
        void _컴퓨터와_플레이어가_같은_수_인_경우_3점을_받습니다() {
            //given
            final var eventContextMock = Mockito.mock(EventContext.class);
            given(eventContextMock.getComputer()).willReturn(new Computer(List.of(1, 2, 3)));
            given(eventContextMock.getUser()).willReturn(new User(List.of(1, 2, 3)));

            //when
            final var score = new RefereeEvent(eventContextMock).execute();

            //then
            Assertions.assertThat(score.getScoreText()).isEqualTo("3스트라이크");
        }

        @Test
        void _2볼_1스트라이크_인_경우() {
            //given
            final var eventContextMock = Mockito.mock(EventContext.class);
            given(eventContextMock.getComputer()).willReturn(new Computer(List.of(1, 2, 3)));
            given(eventContextMock.getUser()).willReturn(new User(List.of(1, 3, 2)));

            //when
            final var score = new RefereeEvent(eventContextMock).execute();

            //then
            Assertions.assertThat(score.getScoreText()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        void _1볼_1스트라이크_인_경우() {
            //given
            final var eventContextMock = Mockito.mock(EventContext.class);
            given(eventContextMock.getComputer()).willReturn(new Computer(List.of(1, 2, 3)));
            given(eventContextMock.getUser()).willReturn(new User(List.of(1, 4, 2)));

            //when
            final var score = new RefereeEvent(eventContextMock).execute();

            //then
            Assertions.assertThat(score.getScoreText()).isEqualTo("1볼 1스트라이크");
        }

        @Test
        void _3볼_인_경우() {
            //given
            final var eventContextMock = Mockito.mock(EventContext.class);
            given(eventContextMock.getComputer()).willReturn(new Computer(List.of(1, 2, 3)));
            given(eventContextMock.getUser()).willReturn(new User(List.of(3, 1, 2)));

            //when
            final var score = new RefereeEvent(eventContextMock).execute();

            //then
            Assertions.assertThat(score.getScoreText()).isEqualTo("3볼");
        }

        @Test
        void _낫싱_인_경우() {
            //given
            final var eventContextMock = Mockito.mock(EventContext.class);
            given(eventContextMock.getComputer()).willReturn(new Computer(List.of(1, 2, 3)));
            given(eventContextMock.getUser()).willReturn(new User(List.of(4, 5, 6)));

            //when
            final var score = new RefereeEvent(eventContextMock).execute();

            //then
            Assertions.assertThat(score.getScoreText()).isEqualTo("낫싱");
        }
    }

}