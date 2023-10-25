package baseball.application.process;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.application.process.base.BaseballProcess;
import baseball.application.process.container.ProcessContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[ProcessContainerTest]")
public class ProcessContainerTest {

    @Test
    @DisplayName("get으로 불러온 프로세스는 모두 같은 객체이다.")
    void hasElevenProcessesWhenConstructed() {
        // given
        ProcessContainer processContainer = new ProcessContainer();

        // when
        BaseballProcess p1 = processContainer.get("gameStartProcess");
        BaseballProcess p2 = processContainer.get("gameStartProcess");

        // then
        assertThat(p1).isEqualTo(p2);
    }
}
