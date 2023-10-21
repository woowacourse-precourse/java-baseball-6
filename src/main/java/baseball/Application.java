package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int click = 0;
        while (click != 2) {
            List<Integer> computerBall = RandomBall.makeRandomBall();
            System.out.println(computerBall);
            boolean loop = false;
            while (!loop) {
                String tempBall = Console.readLine();
                loop = CheckBall.giveBallResult(tempBall, computerBall);
            }
        }

    }
}
