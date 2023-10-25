package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    @DisplayName("제한에 맞는 3가지 숫자를 입력할 경우")
    public void numberTest() throws Exception{
        //given (주어진 값)
        Player player = new Player();
        String number = "456";
        List<Integer> listNumber = new ArrayList<>(Arrays.asList(4,5,6));

        //when (기능수행)
        player.inputPlayerNumber(number);
        List<Integer> playerNumber = player.getPlayerNumber();

        //then (기능 작동 후 결과)
        Assertions.assertThat(playerNumber).isEqualTo(listNumber);
    }

    @Test
    @DisplayName("주어진 값이 틀렸을경우")
    public void isNotNumber() throws Exception{
        //given (주어진 값)
        Player player = new Player();
        String number = "12a";
        String str = "a , 2, b, c";
        String none = "";
        String check = "1,2,";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(number));
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(str));
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(none));
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(check));
    }

    @Test
    @DisplayName("수가 3개가 아닐경우")
    public void isNotNumberSize() throws Exception{
        //given (주어진 값)
        Player player = new Player();
        String number = "1234";
        String one = "1";
        String two = "12";
        String many = "123456789";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(number));
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(one));
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(two));
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(many));
    }

    @Test
    @DisplayName("중복이 있을경우")
    public void isDuplicationNumber() throws Exception{
        //given (주어진 값)
        Player player = new Player();
        String number = "122";
        String three = "111";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(number));
        assertThrows(IllegalArgumentException.class, () -> player.inputPlayerNumber(three));
    }

    @Test
    @DisplayName("게임 종료 혹은 재시작 숫자 입력")
    public void test() throws Exception{
        //given (주어진 값)
        Player player = new Player();
        String one = "1";
        String two = "2";

        //when (기능 작동)
        player.answerRestartOrEnd(one);
        int again = player.getAnswerNumber();

        player.answerRestartOrEnd(two);
        int end = player.getAnswerNumber();

        //then (기능 작동 후 결과)
        Assertions.assertThat(again).isEqualTo(1);
        Assertions.assertThat(end).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 종료 혹은 재시작 숫자가 아닐경우 오류발생")
    public void isNotAnswerNumber() throws Exception{
        //given (주어진 값)
        Player player = new Player();
        String str = "a";
        String none = "";
        String number = ";'";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () -> player.answerRestartOrEnd(str));
        assertThrows(IllegalArgumentException.class, () -> player.answerRestartOrEnd(none));
        assertThrows(IllegalArgumentException.class, () -> player.answerRestartOrEnd(number));
    }

    @Test
    @DisplayName("게임 종료 혹은 재시작 숫자가 1가지가 아닐경우 오류발생")
    public void isNotAnswerNumberSize() throws Exception{
        //given (주어진 값)
        Player player = new Player();
        String two = "12";
        String three = "456";
        String many = "123456789123";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () -> player.answerRestartOrEnd(two));
        assertThrows(IllegalArgumentException.class, () -> player.answerRestartOrEnd(three));
        assertThrows(IllegalArgumentException.class, () -> player.answerRestartOrEnd(many));
    }

    @Test
    @DisplayName("게임 종료 혹은 재시작 숫자가 범위를 벗어날 경우 오류발생")
    public void isNotAnswerNumberRange() throws Exception{
        //given (주어진 값)
        Player player = new Player();
        String number = "3";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () -> player.answerRestartOrEnd(number));
    }
}