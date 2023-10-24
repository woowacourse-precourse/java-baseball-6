package baseball.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void test() {
        Player player = new Player(123);
        Player computerPlayer = new Player(713);

        Referee referee = new Referee(player, computerPlayer);
        System.out.println(referee.result());

    }
}