package baseball.service;

import baseball.controller.BallDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {
    private final GameService service = new GameService();

    @Test
    void 스트라이크_0개(){
        List<BallDto> computer = new ArrayList<>();
        List<BallDto> user = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(new BallDto(i));
        for (int i=4; i<7; i++) user.add(new BallDto(i));

        int result = service.strikeResult(computer, user);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 스트라이크_1개(){
        List<BallDto> computer = new ArrayList<>();
        List<BallDto> user = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(new BallDto(i));

        user.add(new BallDto(1));
        user.add(new BallDto(3));
        user.add(new BallDto(2));

        int result = service.strikeResult(computer, user);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 스트라이크_2개(){
        List<BallDto> computer = new ArrayList<>();
        List<BallDto> user = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(new BallDto(i));
        for (int i=1; i<3; i++) user.add(new BallDto(i));

        user.add(new BallDto(4));

        int result = service.strikeResult(computer, user);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 스트라이크_3개(){
        List<BallDto> computer = new ArrayList<>();
        List<BallDto> user = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(new BallDto(i));
        for (int i=1; i<4; i++) user.add(new BallDto(i));

        int result = service.strikeResult(computer, user);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 볼_0개(){
        List<BallDto> computer = new ArrayList<>();
        List<BallDto> user = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(new BallDto(i));
        for (int i=1; i<4; i++) user.add(new BallDto(i));

        int result = service.ballResult(computer, user);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 볼_1개(){
        List<BallDto> computer = new ArrayList<>();
        List<BallDto> user = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(new BallDto(i));
        for (int i=4; i<6; i++) user.add(new BallDto(i));

        user.add(new BallDto(1));

        int result = service.ballResult(computer, user);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 볼_2개(){
        List<BallDto> computer = new ArrayList<>();
        List<BallDto> user = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(new BallDto(i));
        for (int i=3; i>0; i--) user.add(new BallDto(i));

        int result = service.ballResult(computer, user);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 볼_3개(){
        List<BallDto> computer = new ArrayList<>();
        List<BallDto> user = new ArrayList<>();

        for (int i=1; i<4; i++) computer.add(new BallDto(i));

        user.add(new BallDto(2));
        user.add(new BallDto(3));
        user.add(new BallDto(1));

        int result = service.ballResult(computer, user);

        assertThat(result).isEqualTo(3);
    }
}