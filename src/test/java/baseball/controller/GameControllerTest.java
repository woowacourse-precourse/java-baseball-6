package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameControllerTest {
    @Test
    void 컴퓨터측_볼_생성(){
        List<Integer> ballList = new ArrayList<>();

        for (int i=1; i<4; i++){
            ballList.add(i);
        }

        Computer computer = new Computer(ballList);
        String ballNumber = computer.getBallNumber();

        assertThat(ballNumber.length()).isEqualTo(3);
    }

    @Test
    void 유저측_볼_생성(){
        List<Integer> ballList = new ArrayList<>();

        for (int i=1; i<4; i++){
            ballList.add(i);
        }

        Player player = new Player(ballList);
        String ballNumber = player.getBallNumber();

        assertThat(ballNumber.length()).isEqualTo(3);
    }
}