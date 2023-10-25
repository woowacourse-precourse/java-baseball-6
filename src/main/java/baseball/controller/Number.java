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

    public static List<Integer> receive()
    {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        char[] digits = input.toCharArray();

        if (!input.matches("\\d{3}"))
        {
            throw new IllegalArgumentException("서로 다른 세 자리 수를 입력해야 합니다.");
        }
        else if (digits[0] == digits[1] || digits[1] == digits[2] || digits[0] == digits[2])
        {
            throw new IllegalArgumentException("서로 다른 세 자리 수를 입력해야 합니다.");
        }

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

        if (strikes == 0 && balls == 0) System.out.println("낫싱");
        else if (strikes == 0) System.out.println(balls + "볼");
        else if (balls == 0) System.out.println(strikes + "스트라이크");
        else System.out.println(balls + "볼 " + strikes + "스트라이크 ");

        return strikes;
    }
}
