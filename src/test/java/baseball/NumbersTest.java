package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.number.Number;
import baseball.number.Numbers;
import baseball.result.Result;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    static ByteArrayOutputStream outContent;

    @BeforeEach
    void beforeEach() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("MAX_SIZE 이상의 List가 입력되었을 경우 에러 반환")
    public void MAX_SIZE_이상의_List가_입력되었을_경우_에러_반환() {
        // given
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));
        numbers.add(new Number(4));

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Numbers(numbers));
    }

    @Test
    @DisplayName("숫자_비교-3스트라이크")
    public void 숫자_비교_3스트라이크() {
        // given
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));

        List<Number> numbers2 = new ArrayList<>(numbers);

        // when
        Numbers nums = new Numbers(numbers);
        Numbers nums2 = new Numbers(numbers2);
        Result result = nums.compareWith(nums2);

        // then
        result.printResult();
        String expectedOutput = "3스트라이크" + "\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("숫자_비교-2볼_1스트라이크")
    public void 숫자_비교_2볼_1스트라이크() {
        // given
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));

        List<Number> numbers2 = new ArrayList<>();
        numbers2.add(new Number(1));
        numbers2.add(new Number(3));
        numbers2.add(new Number(2));

        // when
        Numbers nums = new Numbers(numbers);
        Numbers nums2 = new Numbers(numbers2);
        Result result = nums.compareWith(nums2);

        // then
        result.printResult();
        String expectedOutput = "2볼 1스트라이크" + "\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("숫자_비교-낫싱")
    public void 숫자_비교_낫싱() {
        // given
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));

        List<Number> numbers2 = new ArrayList<>();
        numbers2.add(new Number(4));
        numbers2.add(new Number(5));
        numbers2.add(new Number(6));

        // when
        Numbers nums = new Numbers(numbers);
        Numbers nums2 = new Numbers(numbers2);
        Result result = nums.compareWith(nums2);

        // then
        result.checkResult();
        String expectedOutput = "낫싱" + "\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("자릿수를 Number로 변환")
    public void 자릿수를_Number로_변환() {
        // given
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));

        // when
        Numbers nums = new Numbers(numbers);
        Number number = nums.getNumber(0);
        Number number2 = nums.getNumber(1);
        Number number3 = nums.getNumber(2);

        // then
        assertThat(number).isEqualTo(numbers.get(0));
        assertThat(number2).isEqualTo(numbers.get(1));
        assertThat(number3).isEqualTo(numbers.get(2));
    }

    @Test
    @DisplayName("Number를 포함하는지 확인")
    public void Number를_포함하는지_확인() {
        // given
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));

        // when
        Numbers nums = new Numbers(numbers);

        // then
        assertThat(nums.includeNumber(numbers.get(0))).isEqualTo(0);
        assertThat(nums.includeNumber(numbers.get(1))).isEqualTo(1);
        assertThat(nums.includeNumber(numbers.get(2))).isEqualTo(2);
        assertThat(nums.includeNumber(new Number(4))).isEqualTo(-1);
    }
}
