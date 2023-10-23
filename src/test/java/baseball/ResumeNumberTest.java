package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.ResumeNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResumeNumberTest {

    private ResumeNumber resumeNumber;

    @BeforeEach
    void beforeEach() {
        resumeNumber = ResumeNumber.createDefault();
    }

    @Test
    void 재시작_또는_종료값은_한자릿수여야만_한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            resumeNumber.updateNumber("123");
        });
    }

    @Test
    void 재시작_또는_종료값은_숫자여야만_한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            resumeNumber.updateNumber("a");
        });
    }

    @Test
    void 재시작_또는_종료값은_1이_될_수_있다() {
        resumeNumber.updateNumber("1");
    }

    @Test
    void 재시작_상태는_1이다() {
        resumeNumber.updateNumber("1");
        assertThat(resumeNumber.isWantMoreGame()).isTrue();
    }

    @Test
    void 재시작_또는_종료값은_2가_될_수_있다() {
        resumeNumber.updateNumber("2");
    }
}
