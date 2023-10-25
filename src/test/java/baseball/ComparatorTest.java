package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComparatorTest {
    @DisplayName("3스트라이크 테스트")
    @Test
    void threeStrikeTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "345";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(3);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(0);
    }

    @DisplayName("2스트라이크 테스트")
    @Test
    void twoStrikeTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "348";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(2);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(0);
    }

    @DisplayName("1스트라이크 테스트")
    @Test
    void oneStrikeTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "389";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(1);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(0);
    }

    @DisplayName("3볼 테스트")
    @Test
    void threeBallTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "534";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(0);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(3);
    }

    @DisplayName("2볼 테스트")
    @Test
    void twoBallTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "437";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(0);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(2);
    }

    @DisplayName("1볼 테스트")
    @Test
    void oneBallTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "639";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(0);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(1);
    }

    @DisplayName("2볼 1스트라이크 테스트") //1볼 2스트라이크 불가능
    @Test
    void twoBallOneStrikeTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "435";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(1);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(2);
    }

    @DisplayName("1볼 1스트라이크 테스트")
    @Test
    void oneBallOneStrikeTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "374";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(1);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(1);
    }
    
    @DisplayName("낫싱 테스트")
    @Test
    void nothingTest() {
        //given
        Comparator comparator = new Comparator();

        //when
        String computer = "345";
        String user = "987";

        //then
        assertThat(comparator.getResult(computer, user).get("strike")).isEqualTo(0);
        assertThat(comparator.getResult(computer, user).get("ball")).isEqualTo(0);
    }
}