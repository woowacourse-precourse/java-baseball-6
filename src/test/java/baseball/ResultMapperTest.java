package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultMapperTest {

    @Test
    @DisplayName("결과 문구 테스트")
    public void testGetResult1() {
        ResultMapper resultMapper = new ResultMapper();

        assertEquals("3스트라이크", resultMapper.getResult(3, 3));

    }

    @Test
    @DisplayName("결과 문구 테스트")
    public void testGetResult2() {
        ResultMapper resultMapper = new ResultMapper();

        assertEquals("3볼", resultMapper.getResult(0, 3));

    }

    @Test
    @DisplayName("결과 문구 테스트")
    public void testGetResult3() {
        ResultMapper resultMapper = new ResultMapper();

        assertEquals("2스트라이크 1볼", resultMapper.getResult(2, 1));

    }

    @Test
    @DisplayName("결과 문구 테스트")
    public void testGetResult4() {
        ResultMapper resultMapper = new ResultMapper();

        assertEquals("1스트라이크 2볼", resultMapper.getResult(1, 2));

    }

    @Test
    @DisplayName("결과 문구 테스트")
    public void testGetResult5() {
        ResultMapper resultMapper = new ResultMapper();

        assertEquals("낫싱", resultMapper.getResult(0, 0));

    }

}