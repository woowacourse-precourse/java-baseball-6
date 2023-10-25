package baseball.controller;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame
{
    public static int LENGTH = 3;
    public static void start()
    {
        /* Print game start message */
        System.out.println("Starting number baseball game.");
    }

    public static void play()
    {
        /* Random number generation */
        List<Integer> computer = Number.generate();

        int strikeNum = 0;
        while(strikeNum < 3)
        {
            /* Receive user's input */
            List<Integer> user = Number.recieve();

            /* Check strikes and balls */
            strikeNum = Number.check(computer, user);
        }

        System.out.println("You have the correct answer!");
    }

    public static int askReplay()
    {
        /* Ask whether the user will play the game again */
        System.out.print("Are you going to play it again? (1 for yes, 2 for no): ");
        int replay = Integer.parseInt(Console.readLine());

        if (replay == 1 || replay == 2) {
            return replay;
        } else {
            System.out.print("Wrong number. ");
            return askReplay();
        }
    }
}
