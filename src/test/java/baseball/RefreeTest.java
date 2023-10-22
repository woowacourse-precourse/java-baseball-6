package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefreeTest {
    final List<Integer> computerNum = new ArrayList<>(List.of(1,2,3));

    @Test
    void 판정_1볼() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(4,1,5));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("1볼");
    }

    @Test
    void 판정_2볼() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(4,1,2));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("2볼");
    }

    @Test
    void 판정_3볼() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(3,1,2));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("3볼");
    }

    @Test
    void 판정_1스트라이크() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(1,4,5));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("1스트라이크");
    }

    @Test
    void 판정_2스트라이크() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(1,2,5));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("2스트라이크");
    }

    @Test
    void 판정_3스트라이크() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(1,2,3));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("3스트라이크");
    }

    @Test
    void 판정_1볼_1스트라이크() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(1,3,5));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 판정_2볼_1스트라이크() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(1,3,2));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 낫싱() {
        Refree refree = new Refree();
        List<Integer> playerNum = new ArrayList<>(List.of(4,5,6));

        assertThat(refree.count(computerNum, playerNum)).isEqualTo("낫싱");
    }
}
