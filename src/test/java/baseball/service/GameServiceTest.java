package baseball.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {
    private final GameService service = new GameService();

    @Test
    void 스트라이크_0개(){
        String computer = "123";
        String player = "312";

        int result = service.strikeResult(computer, player);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 스트라이크_1개(){
        String computer = "123";
        String player = "132";

        int result = service.strikeResult(computer, player);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 스트라이크_2개(){
        String computer = "123";
        String player = "128";

        int result = service.strikeResult(computer, player);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 스트라이크_3개(){
        String computer = "123";
        String player = "123";

        int result = service.strikeResult(computer, player);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 볼_0개(){
        String computer = "123";
        String player = "123";

        int result = service.ballResult(computer, player);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 볼_1개(){
        String computer = "123";
        String player = "138";

        int result = service.ballResult(computer, player);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 볼_2개(){
        String computer = "123";
        String player = "132";

        int result = service.ballResult(computer, player);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 볼_3개(){
        String computer = "123";
        String player = "312";

        int result = service.ballResult(computer, player);

        assertThat(result).isEqualTo(3);
    }
}