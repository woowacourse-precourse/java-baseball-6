package baseball.model;

import baseball.domain.Numbers;
import baseball.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultTest {
    @DisplayName("Numbers의 비교롤 통한 result 생성 기능")
    @Test
    void 결과_생성(){
        //둘다 1스트라이크 1볼이 나온다.
        Result result1=new Result(new Numbers("123"),new Numbers("134"));
        Result result2=new Result(new Numbers("123"),new Numbers("243"));

        assertThat(result1.equals(result2)).isTrue();
    }

    @DisplayName("낫싱 확인 기능")
    @Test
    void 낫싱_확인(){
        Result nothing=new Result(new Numbers("123"),new Numbers("456"));

        assertThat(nothing.isNothing()).isTrue();
    }

    @DisplayName("결과 값 문자열 반환 기능")
    @ParameterizedTest
    @CsvSource(value={"134:1볼 1스트라이크","456:낫싱"},delimiter = ':')
    void 결과_문자열_반환(String numbers,String expected){
        Result result=new Result(new Numbers("123"),new Numbers(numbers));

        assertThat(result.getResult()).isEqualTo(expected);
    }
}
