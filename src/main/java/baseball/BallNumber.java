package baseball;

import java.util.Map;
import java.util.Random;

public class BallNumber {
    private int num;
    private int ballDP[] = new int[3];
    public BallNumber(int number){


    }

    private int randomNum(){
        Random random = new Random();
        return random.nextInt(9);
    }

    public int makeNumber(){
        ballDP[0] = this.num;
        return 1;
    }
}
