package baseball.baseTest;

import constant.BaseConst;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.BaseRepository;
import repository.BaseRepositoryImpl;

import java.util.Arrays;
import java.util.List;

import static constant.BaseConst.*;
import static org.assertj.core.api.Assertions.*;

public class BaseRepositoryTest {

    private final BaseRepository baseRepository = new BaseRepositoryImpl();


    @Test
    @DisplayName("내 번호 생성")
    void getMyNumber() {
        String myNumber1 = "123";

        List<Integer> myNumberList = baseRepository.getMyNumber(myNumber1);

        assertThat(myNumberList).isEqualTo(Arrays.asList(1, 2, 3));


    }

    @Test
    @DisplayName("결과값 생성")
    void confirmNumber() {
        List<Integer> baseNumber1 = Arrays.asList(5, 2, 3);
        List<Integer> myNumber1 = Arrays.asList(3, 4, 5);

        int[] result1 = baseRepository.confirmNumber(baseNumber1, myNumber1);

        assertThat(result1[STRIKE]).isEqualTo(0);
        assertThat(result1[BALL]).isEqualTo(2);
        ////////////////////////////////////////////////////////////////////////

        List<Integer> baseNumber2 = Arrays.asList(8, 3, 5);
        List<Integer> myNumber2 = Arrays.asList(8, 7, 5);

        int[] result2 = baseRepository.confirmNumber(baseNumber2, myNumber2);

        assertThat(result2[STRIKE]).isEqualTo(2);
        assertThat(result2[BALL]).isEqualTo(0);
        ////////////////////////////////////////////////////////////////////////

        List<Integer> baseNumber3 = Arrays.asList(3, 5, 9);
        List<Integer> myNumber3 = Arrays.asList(3, 5, 9);

        int[] result3 = baseRepository.confirmNumber(baseNumber3, myNumber3);

        assertThat(result3[STRIKE]).isEqualTo(3);
        assertThat(result3[BALL]).isEqualTo(0);
    }
}
