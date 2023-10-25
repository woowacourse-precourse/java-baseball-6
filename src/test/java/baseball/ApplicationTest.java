package baseball;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.RestartNum;
import baseball.model.validator.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 컴퓨터가_숫자를_랜덤으로_생성() {
        //given
        Computer computer = new Computer();
        //when
        computer.setComputerNumber();
        //then
        assertThat(computer.getComputerNumber().length()).isEqualTo(3);
    }

    @Test
    void player_숫자_입력_여부() {
        //given
        String playerNumber = "a21";
        Player player = new Player(playerNumber);

        //when
        String str = player.getPlayerNumber();

        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Player.isDigitNumber(str))
                        .isInstanceOf(IllegalArgumentException.class)
        ); // 숫자가 아님 예외발생.
    }

    @Test
    void player_숫자길이_중복여부() {
        //given
        String playerNumber = "122";
        Player player = new Player(playerNumber);

        //when
        String str = player.getPlayerNumber();

        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Player.differentToPlayerNumber(str))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자비교() {
        //given
        Validator validator = new Validator();
        String computer = "713";
        String player = "123"; // 1볼 1스트라이크

        //when
        int[] numberCompare = validator.getNumberCompare(computer, player);

        //then
        assertThat(numberCompare[0]).isEqualTo(1);
        assertThat(numberCompare[1]).isEqualTo(1);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 게임_재시작() {
        // given
        RestartNum restartNum = new RestartNum("1");

        // when
        String num = restartNum.getRestartNum();
        System.out.println(num);

        // then
        assertSimpleTest(() ->
                assertThatCode(() -> RestartNum.equalsRestartNum(num))
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
