package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
        /* Play baseball game */

        /* Random number generation */
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < LENGTH)
        {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
            {
                computer.add(randomNumber);
            }
        }

        /* Receive user's input */
        System.out.print("Insert number with three digits: ");
        String input = Console.readLine();

        /* Check if the input has overlapping numbers */
        // implement later : after separating methods and classes

        /* Make input as array */
        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++)
        {
            user.add(Character.getNumericValue(input.charAt(i)));
        }

        /* Check if there are strikes */
        List<Boolean> checkStrike = new ArrayList<>();
        int strikes = 0;
        for (int i = 0; i < LENGTH; i++)
        {
            if (computer.get(i).equals(user.get(i)))
            {
                checkStrike.add(true);
                strikes++;
            }
            else checkStrike.add(false);
        }
        System.out.println("ok"); // 두번나옴
        System.out.println(checkStrike);

        /* Check if there are balls */
        int balls = 0;
        for (int i = 0; i < LENGTH; i++)
        {
            if (checkStrike.get(i).equals(false))
            {
                if (computer.contains(user.get(i)))
                {
                    balls++;
                }
            }
        }

        if (strikes == 2) System.out.println("정답");
        else System.out.println(strikes + " strikes " + balls + " ball");

        System.out.println("computer number: " + computer);

        return;
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
