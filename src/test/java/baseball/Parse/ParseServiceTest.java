package baseball.Parse;

import baseball.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.Constant.*;

import static org.junit.jupiter.api.Assertions.*;

class ParseServiceTest {

    private ParseService parseService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        parseService = appConfig.parseService();
    }

    @Test
    @DisplayName("문자열을 List<Integer>형태로 치환한다,")
    void stringParseToNumbers() {
        // given
        String line = "123";
        // when
        List<Integer> numbers = parseService.stringParseToNumbers(line);
        // then
        Assertions.assertThat(numbers).containsExactly(1,2,3);
    }

    @Test
    @DisplayName("올바르지 않은 입력 값이 들어올 경우 IllegalArgumentException을 발생시킨다.")
    void stringParsingError() {
        // given, when, then
        Assertions.assertThatThrownBy(() -> parseService.stringParseToNumbers("1234"));
        Assertions.assertThatThrownBy(() -> parseService.stringParseToNumbers("12"));
        Assertions.assertThatThrownBy(() -> parseService.stringParseToNumbers("asdf"));
    }

    @Test
    @DisplayName("RESTART_FLAG를 누르면 재시작(true), END_FLAG를 누르면 종료(false)를 한다")
    void checkRestart() {
        // given, when, then
        assertTrue(parseService.isRestart(RESTART_FLAG));
        assertFalse(parseService.isRestart(END_FLAG));
    }
}