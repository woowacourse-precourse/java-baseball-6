package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @DisplayName("입력한 값의 길이가 3자리 미만일때")
    @Test
    void underThreeLength(){
        //given
        String underThreeLengthNum = "12";
        //when
        //then
        assertThat(Validator.checkLength(underThreeLengthNum)).isFalse();

    }

    @DisplayName("입력한 값의 길이가 3자리 초과일때")
    @Test
    void overThreeLength(){
        //given
        String overThreeLengthNum = "1234";
        //when
        //then
        assertThat(Validator.checkLength(overThreeLengthNum)).isFalse();

    }

    @DisplayName("입력한 값의 길이가 3자리일때")
    @Test
    void isThreeLength(){
        //given
        String threeLengthNum = "123";
        //when
        //then
        assertThat(Validator.checkLength(threeLengthNum)).isTrue();
    }

    @DisplayName("0이 존재할때 테스트")
    @Test
    void includeZeroTest(){
        //given
        String includeZero = "012";
        //when
        //then
        assertThat(Validator.checkZeroNum(includeZero)).isFalse();

    }
    @DisplayName("0이 존재 안할때 테스트")
    @Test
    void excludeZeroTest(){
        //given
        String includeZero = "412";
        //when
        //then
        assertThat(Validator.checkZeroNum(includeZero)).isTrue();
    }
    @DisplayName("중복값이 존재할때")
    @Test
    void includeDuplicateNum(){
        //given
        String duplicateNum = "112";
        //when
        //then
        assertThat(Validator.checkDuplicationNum(duplicateNum)).isFalse();

    }

    @DisplayName("중복값이 존재 안할때")
    @Test
    void excludeDuplicateNum(){
        //given
        String duplicateNum = "123";
        //when
        //then
        assertThat(Validator.checkDuplicationNum(duplicateNum)).isTrue();
    }

    @DisplayName("리스트안에 특정 값이 존재하는 경우 확인")
    @Test
    void isNumInList(){
        //given
        List<String> list = List.of("1", "2");
        String inNum = "1";
        //when
        //then
        assertThat(Validator.validNumNotInList(inNum, list)).isTrue();
    }

    @DisplayName("리스트안에 특정 값이 존재 안하는 경우 테스트")
    @Test
    void test(){
        //given
        List<String> list = List.of("1", "2");
        String notInNum = "4";
        //when
        //then
        assertThat(Validator.validNumNotInList(notInNum, list)).isFalse();
    }

}