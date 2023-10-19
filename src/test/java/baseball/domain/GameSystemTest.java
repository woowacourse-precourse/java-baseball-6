package baseball.domain;

import org.junit.jupiter.api.Test;

class GameSystemTest {

    @Test
    void getSystemBaseBallNumber() {
        //given
        GameSystem gameSystem ;
       
        //when
        gameSystem= new GameSystem();
        
        //then
        System.out.println("gameSystem.getSystemBaseBallNumber() = " + gameSystem.getSystemBaseBallNumber());
    }
}