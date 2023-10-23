package baseball.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {
    private final GameService service = new GameService();

    @Test
    void 스트라이크_0개(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(i);

        player.add(3);
        player.add(1);
        player.add(2);

        int result = service.strikeResult(computer, player);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 스트라이크_1개(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(i);

        player.add(1);
        player.add(3);
        player.add(2);

        int result = service.strikeResult(computer, player);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 스트라이크_2개(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(i);
        for (int i=1; i<3; i++) player.add(i);

        player.add(8);

        int result = service.strikeResult(computer, player);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 스트라이크_3개(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        for (int i=1; i<4; i++){
            computer.add(i);
            player.add(i);
        }

        int result = service.strikeResult(computer, player);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 볼_0개(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        for (int i=1; i<4; i++){
            computer.add(i);
            player.add(i);
        }

        int result = service.ballResult(computer, player);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 볼_1개(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(i);

        player.add(1);
        player.add(3);
        player.add(8);

        int result = service.ballResult(computer, player);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 볼_2개(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(i);

        player.add(1);
        player.add(3);
        player.add(2);

        int result = service.ballResult(computer, player);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 볼_3개(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(i);

        player.add(3);
        player.add(1);
        player.add(2);

        int result = service.ballResult(computer, player);

        assertThat(result).isEqualTo(3);
    }
}