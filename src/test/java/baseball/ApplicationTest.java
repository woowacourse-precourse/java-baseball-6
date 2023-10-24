package baseball;

import baseball.baseballGame.BaseBallGame;
import baseball.baseballGame.CheckValidNum;
import baseball.baseballGame.CompareNum;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 랜덤한_숫자선택_테스트() {
        int cnt = 3;
        BaseBallGame bGame = new BaseBallGame(cnt);

        bGame.init();

        assertThat(String.valueOf(bGame.getComputerNum()).length()).isEqualTo(cnt);
    }

    @Test
    void 숫자_비교_테스트() {
        CompareNum cn = new CompareNum();

        Map<String, Integer> map = cn.compare(123, 123);
        assertThat(map.get("strike")).isEqualTo(3);
        assertThat(map.get("ball")).isEqualTo(0);

        map = cn.compare(125, 123);
        assertThat(map.get("strike")).isEqualTo(2);
        assertThat(map.get("ball")).isEqualTo(0);

        map = cn.compare(531, 248);
        assertThat(map.get("strike")).isEqualTo(0);
        assertThat(map.get("ball")).isEqualTo(0);

        map = cn.compare(125, 851);
        assertThat(map.get("strike")).isEqualTo(0);
        assertThat(map.get("ball")).isEqualTo(2);
    }

    @Test
    void 입력_숫자_유효성체크(){
        CheckValidNum checkNum = new CheckValidNum();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> checkNum.check(012));
        e = assertThrows(IllegalArgumentException.class, () -> checkNum.check(-135));
        e = assertThrows(IllegalArgumentException.class, () -> checkNum.check(121));
        e = assertThrows(IllegalArgumentException.class, () -> checkNum.check(15));
        e = assertThrows(IllegalArgumentException.class, () -> checkNum.check(4567));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
