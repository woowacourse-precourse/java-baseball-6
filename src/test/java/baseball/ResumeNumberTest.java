package baseball;

import baseball.model.number.ResumeNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ResumeNumberTest {

    @Test
    void 재시작_또는_종료값은_한자릿수여야만_한다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ResumeNumber resumeNumber = ResumeNumber.from("123");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(RESUME_VALUE_EXCEPTION.toString());
    }

    @Test
    void 재시작_또는_종료값은_숫자여야만_한다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ResumeNumber resumeNumber = ResumeNumber.from("a");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(RESUME_VALUE_EXCEPTION.toString());
    }

    @Test
    void 재시작_또는_종료값은_1이_될_수_있다() {
        ResumeNumber resumeNumber = ResumeNumber.from("1");
    }

    @Test
    void 재시작_상태는_1이다() {
        // given & when
        ResumeNumber resumeNumber = ResumeNumber.from("1");
        // then
        assertThat(resumeNumber.isWantMoreGame()).isTrue();
    }

    @Test
    void 재시작_또는_종료값은_2가_될_수_있다() {
        ResumeNumber resumeNumber = ResumeNumber.from("2");
    }

    @Test
    void 종료_상태는_2이다() {
        // given & when
        ResumeNumber resumeNumber = ResumeNumber.from("2");
        // then
        assertThat(resumeNumber.isWantMoreGame()).isFalse();
    }
}
