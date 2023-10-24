package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CreateRandomNum randomNum = new CreateRandomNum();
        Input input = new Input();
        Score score = new Score();
        Restart restart = new Restart();
        boolean again = true;

        while(again) {
            List<Integer> computer = randomNum.create();
            String result = "";
            while(!result.equals("3스트라이크")) {
                result = score.score(computer, input.playerNumber());
                System.out.println(result);
            }
            again = restart.restart();
        }


    }
}
