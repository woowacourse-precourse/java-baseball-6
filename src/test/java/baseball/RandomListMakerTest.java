package baseball;

import baseball.controller.RandomListMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomListMakerTest {
    private final static int LIST_SIZE = 3;

    @DisplayName("생성된 리스트의 개수가 3개면 성공")
    @Test
    void returnThreeSizeOfList(){
        RandomListMaker randomListMaker = new RandomListMaker();
        List<Integer> integerList = randomListMaker.generateRandomNumbers();
        assertThat(integerList.size() == LIST_SIZE);
    }
}
