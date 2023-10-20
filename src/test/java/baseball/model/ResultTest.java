package baseball.model;

import baseball.domain.Numbers;
import baseball.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
