package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.controller.BaseballGame.LENGTH;

public class Number
{
    public static List<Integer> generate()
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < LENGTH)
        {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
            {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> recieve()
    {
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
        return user;
    }

    public static int check(List<Integer> computer, List<Integer> user)
    {
        int strikes = 0;
        int balls = 0;

        /* Check if there are strikes */
        List<Boolean> checkStrike = new ArrayList<>();

        for (int i = 0; i < LENGTH; i++)
        {
            if (computer.get(i).equals(user.get(i)))
            {
                checkStrike.add(true);
                strikes++;
            }
            else checkStrike.add(false);
        }

        /* Check if there are balls */
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

        if (strikes == 0 && balls == 0) System.out.println("Nothing");
        else if (strikes == 0) System.out.println(balls + " ball");
        else if (balls == 0) System.out.println(strikes + " strike");
        else System.out.println(strikes + " strike " + balls + " ball");

        System.out.println("computer number: " + computer);

        return strikes;
    }
}
