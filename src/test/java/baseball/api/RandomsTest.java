package baseball.api;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    @Test
    @DisplayName("startInclusive~ endInclusive 사이에서의 난수를 생성합니다.")
    public void test_pickNumberInRange() throws Exception {
        // GIVEN
        int startInclusive = 0;
        int endInclusive = 10;

        try {
            // WHEN
            int i = Randoms.pickNumberInRange(startInclusive, endInclusive);
            // startInclusive + defaultRandom.nextInt(endInclusive - startInclusive + 1); : 10-1+1
            // THEN
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("0~List 의 길이 사이 난수값 인덱스의 List 가 가지고 있는 값을 반환합니다.")
    public void test_pickNumberInList() throws Exception {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        Integer size = 15;
        for (int i = 0; i < size; i++) {
            userInputs.add(i);
        }

        // WHEN
        int i = Randoms.pickNumberInList(userInputs); // 0~길이 사이 난수값 인덱스가 가르키는 값 반환

        // THEN
        System.out.println(i);

    }


    @Test
    @DisplayName("주어진 List의 순서를 섞습니다.")
    public void test_shuffle() throws Exception {
        // GIVEN
        List<Integer> inputs = new ArrayList<>();
        inputs.add(1);
        inputs.add(2);
        inputs.add(3);

        // WHEN
        List<Integer> shuffledInputs = Randoms.shuffle(inputs); // does not always different ordered list

        // THEN
        assertThat(inputs).hasSize(shuffledInputs.size()); // has same size
        assertThat(inputs).containsAll(shuffledInputs);
        System.out.println("inputs : " + inputs.toString());
        System.out.println("shuffledInputs : " + shuffledInputs.toString());


    }

    @Test
    @DisplayName("startInclusive부터 endInclusive까지의 리스트를 섞고 count만큼 자른 List를 반환합니다.")
    public void test_pickUniqueNumbersInRange() throws Exception {
        // GIVEN
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(0, 10, 3);

        // WHEN

        // THEN

        System.out.println(integers.toString());

    }

}
