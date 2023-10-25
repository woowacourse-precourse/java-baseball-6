package domainTest;

import baseball.domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerTest {

    @Test
    @DisplayName("String 에서 Int형으로 형변환이 잘 되어 리스트로 저장되는지 확인한다.")
    void stringToIntTest(){
        //given
        String input = "123";
        Player player = new Player();
        //when
        player.callNumber(input);
        //then
        Assertions.assertEquals(List.of(1,2,3),player.getNumber());
    }
}
