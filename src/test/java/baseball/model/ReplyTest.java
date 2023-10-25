package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ReplyTest {

    Reply reply;

    @BeforeEach
    void init() {
        List<Integer> computerNumber = new ArrayList<>();
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);

        List<Integer> playerNumber = new ArrayList<>();
        playerNumber.add(2);
        playerNumber.add(4);
        playerNumber.add(3);

        reply = new Reply(computerNumber, playerNumber);
    }

    @Test
    void checkCountBallAndStrikeTest() {
        reply.setBallAndStrike();
        Assertions.assertThat(reply.ballCnt).isEqualTo(1);
        Assertions.assertThat(reply.strikeCnt).isEqualTo(1);
    }
}