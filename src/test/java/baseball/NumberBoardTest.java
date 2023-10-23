package baseball;

import org.junit.jupiter.api.Test;


public class BaseballGameTest {

    @Test
    public void test(){
        BaseballGame baseballGame = new BaseballGame();
        NumberBoard numberBoard1 = baseballGame.getNumberBoard();
        int size = numberBoard1.size();

        for(int i=0; i<size; i++){
            System.out.println(numberBoard1.posNumber(i));
        }

        NumberBoard numberBoard2 = new NumberBoard(NumberBoard.makeRandomBoard());
        for(int i=0; i<size; i++){
            System.out.println("numberBoard2 = " + numberBoard2.posNumber(i));
        }
    }
}
