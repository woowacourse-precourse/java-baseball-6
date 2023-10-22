package baseball;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.function.BinaryOperator;

public class GameStatus {
    private boolean isGameOnGoing= true;

    public boolean getIsGameOnGoing() {
        return isGameOnGoing;
    }

    public void setIsGameOnGoing(boolean gameOnGoing) {
        isGameOnGoing = gameOnGoing;
    }

    public void threeStrikeCase()
    {
        System.out.println("case");
        Scanner input = new Scanner(System.in);
        int reInput= input.nextInt();

        if (reInput==1)
        {
            setIsGameOnGoing(true);

        }

        if (reInput==2)
        {
            setIsGameOnGoing(false);

        }
    }
}
