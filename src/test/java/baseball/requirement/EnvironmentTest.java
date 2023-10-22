package baseball.requirement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("프로그래밍 요구사항")
class EnvironmentTest {

    @DisplayName("java17버전 확인")
    @Test
    void testVerifyJavaVersion17() {
        String javaVersion = System.getProperty("java.version");
        assertThat(javaVersion).contains("17");
    }
}
