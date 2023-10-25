package domainTest;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class RefreeTest {

    @Test
    @DisplayName("스트라이크 카운트 체크")
    void strikeCountTest(){
        //given
        Player player = new Player();
        player.callNumber("123");
        Computer computer = Mockito.mock(Computer.class);
        Referee referee = new Referee(computer,player);

        //when
        Mockito.when(computer.getNumber()).thenReturn(List.of(1,2,4));
        referee.checkResult();

        //then
        Assertions.assertEquals(2,referee.getStrike());
    }

    @Test
    @DisplayName("볼 카운트 체크")
    void ballCountTest(){
        //given
        Player player = new Player();
        player.callNumber("351");
        Computer computer = Mockito.mock(Computer.class);
        Referee referee = new Referee(computer,player);

        //when
        Mockito.when(computer.getNumber()).thenReturn(List.of(1,2,3));
        referee.checkResult();

        //then
        Assertions.assertEquals(2,referee.getBall());
    }
}
