package study;

import baseball.Player;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest {
    @Test
    void Randoms_메서드_테스트() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        Boolean inRange = true;
        if(randomNumber >= 1 && randomNumber <= 9){
            inRange = true;
        } else {
            inRange = false;
        }
        assertThat(inRange).isTrue();
    }

    @Test
    void 사용자_입력_스트링_리스트로_정상_변환_테스트() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> playerNum = Player.enter();

        List<Integer> expected = List.of(1,2,3);
        assertThat(expected).isEqualTo(playerNum);
    }

    @Test
    void 문자열에서_특정_위치_문자_찾기_테스트() {
        String playerString = "123";
        char digitChar = playerString.charAt(0);
        assertThat(digitChar).isEqualTo('1');
    }

    @Test
    void 문자에서_숫자로_변환_테스트() {
        int digit = Character.getNumericValue('1');
        assertThat(digit).isEqualTo(1);
    }
}
