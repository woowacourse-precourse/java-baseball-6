package baseball;

import baseball.Model.CreateRandomNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumberTest {
    @Test
    void 세_자리_수인지_확인(){
        CreateRandomNum createRandomNum = new CreateRandomNum();
        List<Integer> result = createRandomNum.create();

        Assertions.assertThat(result.size()).isEqualTo(3);
    }
    @Test
    void 각_자리_숫자가_1부터_9까지_수인지_확인(){
        CreateRandomNum createRandomNum = new CreateRandomNum();
        List<Integer> result = createRandomNum.create();

        for (int number : result) {
            Assertions.assertThat(number >= 1 && number <= 9).isTrue();
        }
    }
    @Test
    void 중복된_숫자가_없는지_확인(){
        CreateRandomNum createRandomNum = new CreateRandomNum();
        List<Integer> result = createRandomNum.create();

        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                Assertions.assertThat(result.get(i)).isNotEqualTo(result.get(j));
            }
        }
    }

}
