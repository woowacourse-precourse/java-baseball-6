package baseball.entity;

import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void test() {
        UserPlayer userPlayer = new UserPlayer(123);
        UserPlayer computerUserPlayer = new UserPlayer(713);

        Referee referee = new Referee(userPlayer, computerUserPlayer);
        System.out.println(referee.result());

    }
}