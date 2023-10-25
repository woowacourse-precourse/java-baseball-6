package baseball.controller;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame
{
    public static int LENGTH = 3;
    public static void start()
    {
        /* Print game start message */
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void play()
    {
        /* Random number generation */
        List<Integer> computer = Number.generate();

        int strikeNum = 0;
        while(strikeNum < 3)
        {
            /* Receive user's input */
            List<Integer> user = Number.receive();

            /* Check strikes and balls */
            strikeNum = Number.check(computer, user);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static int askReplay()
    {
        /* Ask whether the user will play the game again */
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replay = Integer.parseInt(Console.readLine());

        if (replay == 1 || replay == 2) {
            return replay;
        } else {
            throw new IllegalArgumentException("1과 2 중 하나를 입력해야 합니다.");
        }
    }
}
