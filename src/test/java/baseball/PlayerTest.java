package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    // https://steadyjay.tistory.com/10 감사합니다 ㅠㅠ
    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    // https://hannamedia.tistory.com/26 정말로 감사합니다 ㅠㅠㅠㅠㅠ
    @AfterEach
    void closeScanner() {
        Console.close();
    }

    @Test
    void initNumbers_길이_제한_테스트() {

        Player player = new Player();

        systemIn("1234\n");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> player.initNumbers())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void initNumbers_List_문자_포함_테스트() {

        Player player = new Player();

        systemIn("1a3\n");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> player.initNumbers())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void initNumbers_List_생성_성공_테스트() {

        Player player = new Player();

        systemIn("123\n");

        player.initNumbers();

        List<Integer> result = player.getNumbers();
        List<Integer> prediction = new ArrayList<>(Arrays.asList(1, 2, 3));

        assertThat(result).isEqualTo(prediction);
    }

    @Test
    void inputWhetherOfGamePlay_재시작_테스트() {

        Player player = new Player();

        systemIn("1\n");

        int result = player.inputWhetherOfGamePlay();
        int prediction = 1;

        assertThat(result).isEqualTo(prediction);

    }

    @Test
    void inputWhetherOfGamePlay_게임종료_테스트() {

        Player player = new Player();

        systemIn("2\n");

        int result = player.inputWhetherOfGamePlay();
        int prediction = 2;

        assertThat(result).isEqualTo(prediction);

    }

    @Test
    void inputWhetherOfGamePlay_길이제한_예외_테스트() {

        Player player = new Player();

        systemIn("13\n");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> player.inputWhetherOfGamePlay())
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void inputWhetherOfGamePlay_잘못된입력_예외_테스트() {

        Player player = new Player();

        systemIn("A\n");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> player.inputWhetherOfGamePlay())
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }
}
