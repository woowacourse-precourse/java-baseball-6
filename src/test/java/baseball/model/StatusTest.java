package baseball.model;

import static baseball.model.Status.REPLAY;
import static baseball.model.Status.STOP;
import static baseball.model.message.ErrorMessage.INVALID_REPLAY_STATUS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatusTest {

    @Test
    @DisplayName("알맞은 Status 입력 형식은 Status 생성한다.")
    public void 알맞은_Status_입력_형식은_Status_생성한다() {
        //given
        String replayStatus = "1";
        String stopStatus = "2";

        //when
        Status replayStatusResult = Status.from(replayStatus);
        Status stopStatusResult = Status.from(stopStatus);

        //then
        assertThat(replayStatusResult).isEqualTo(REPLAY);
        assertThat(stopStatusResult).isEqualTo(STOP);
    }

    @Test
    @DisplayName("존재하지 않는 Status 입력 형식은 IllegalArgumentException 반환한다.")
    public void 존재하지_않는_Status_입력_형식은_IllegalArgumentException_반환한다() {
        //given
        String invalidStatus = "0";

        //when & then
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            Status.from(invalidStatus);
        });

        assertThat(illegalArgumentException).hasMessage(INVALID_REPLAY_STATUS.getMessage());
    }
}
