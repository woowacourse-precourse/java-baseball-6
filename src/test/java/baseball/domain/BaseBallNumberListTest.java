package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.application.NumericString;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallNumberListTest {

    @Test
    @DisplayName("리스트의 길이가 3이 아닐때 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_lengthOfTheListIsNot3() {

        assertThatThrownBy(() ->
                new BaseBallNumberList(
                        List.of(1, 5, 9, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자로 숫자를 3개가 아닌 입력시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_inputForStringLengthIsNot3() {
        assertThatThrownBy(() ->
                new BaseBallNumberList(new NumericString(
                        "41").toList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 숫자가 존재 할시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_haveASameNumber() {
        assertThatThrownBy(() ->
                new BaseBallNumberList(List.of(1, 4, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("9보다 큰 숫자가 존재 할시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_haveGreaterThanNineNumber() {
        assertThatThrownBy(() ->
                new BaseBallNumberList(List.of(1, 10, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1보다 작은 숫자가 존재 할시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_haveLessThanOneNumber() {
        assertThatThrownBy(() ->
                new BaseBallNumberList(List.of(1, 9, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("두개의 리스트에 같은 숫자가 있다면 count값을 리턴한다")
    void should_returnCount_when_haveSameNumber() {
        BaseBallNumberList baseBallNumberList1 = new BaseBallNumberList(List.of(1, 4, 2));
        BaseBallNumberList baseBallNumberList2 = new BaseBallNumberList(List.of(2, 3, 4));

        assertThat(baseBallNumberList1.countSameNumber(baseBallNumberList2)).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 숫자가 인덱스가 다르다면 True를 리턴")
    void should_returnTrue_when_sameNumberInTheSameIndex() {
        BaseBallNumberList baseBallNumberList1 = new BaseBallNumberList(List.of(1, 4, 2));
        BaseBallNumberList baseBallNumberList2 = new BaseBallNumberList(List.of(4, 3, 2));

        assertThat(baseBallNumberList1.equalAt(2,baseBallNumberList2)).isTrue();
    }

    @Test
    @DisplayName("같은 숫자가 인덱스가 다르다면 False를 리턴")
    void should_returnFalse_when_sameNumberInTheNotSameIndex() {
        BaseBallNumberList baseBallNumberList1 = new BaseBallNumberList(List.of(1, 4, 2));
        BaseBallNumberList baseBallNumberList2 = new BaseBallNumberList(List.of(4, 3, 2));

        assertThat(baseBallNumberList1.equalAt(1,baseBallNumberList2)).isFalse();
    }
}
