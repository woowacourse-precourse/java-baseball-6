package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class ModelTest {
    BaseballGameUtils baseballGameUtils = new BaseballGameUtils();

    @Test
    @DisplayName("반환 스코어 테스트")
    public void testCheckScore() {
        //given
        List<Integer> computerNumber = new ArrayList<>(); //ComputerNumber 클래스를 만들면 임의로 세팅할 수 없으므로
        UserNumber userNumber;

        //when
        computerNumber.add(4);
        computerNumber.add(8);
        computerNumber.add(9);

        userNumber = new UserNumber(819);

        //then
        Score score = baseballGameUtils.checkScore(computerNumber, userNumber.getNumber());

        Assertions.assertThat(score.getBall()).isEqualTo(1);
        Assertions.assertThat(score.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("컴퓨터 숫자 생성 테스트")
    public void testComputerNumber() {
        //given
        ComputerNumber computerNumber;
        List<Integer> computerNumberList;

        //when
        computerNumber = new ComputerNumber();
        computerNumberList = computerNumber.getNumber();

        //then
        Assertions.assertThat(computerNumberList.size()).isEqualTo(3); //사이즈 확인

        Assertions.assertThat(computerNumberList.get(0)).isNotEqualTo(computerNumberList.get(1)); //중복확인
        Assertions.assertThat(computerNumberList.get(0)).isNotEqualTo(computerNumberList.get(2));
        Assertions.assertThat(computerNumberList.get(1)).isNotEqualTo(computerNumberList.get(2));

        for (int i = 0; i < computerNumber.getNumber().size(); i++) { //숫자 크기 확인
            Assertions.assertThat(computerNumber.getNumber().get(i)).isGreaterThanOrEqualTo(1);
            Assertions.assertThat(computerNumber.getNumber().get(i)).isLessThanOrEqualTo(9);
        }

    }

    @Test
    @DisplayName("유저 숫자 생성 테스트")
    public void testUserNumber() {
        //given
        int input1;
        int input2;
        UserNumber userNumber1;
        List<Integer> userNumberList1;

        //when
        input1 = 663;
        input2 = 7234;
        userNumber1 = new UserNumber(324);
        userNumberList1 = userNumber1.getNumber();

        //then
        Assertions.assertThatThrownBy(() -> {
            new UserNumber(input1);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            new UserNumber(input2);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThat(userNumberList1.size()).isEqualTo(3);
        Assertions.assertThat(userNumberList1.get(0)).isEqualTo(3);
        Assertions.assertThat(userNumberList1.get(1)).isEqualTo(2);
        Assertions.assertThat(userNumberList1.get(2)).isEqualTo(4);
    }

}
