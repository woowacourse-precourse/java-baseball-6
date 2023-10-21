package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    int start = 1;
    List<Integer> userInputList = new ArrayList<>();
    String[] inputs = new String[3];
    Decision decision = new Decision();

    public void play(List<Integer> answer) {
        while(start != 2) {
            System.out.print("숫자를 입력해주세요 : ");
            try {
                String inputNumber = Console.readLine();
                inputs = inputNumber.split("");

                for(int i=0; i<3; i++) {
                    userInputList.add(i, Integer.parseInt(inputs[i]));
                }

                int countStrike = decision.countStrike(userInputList, answer);
                int countBall = decision.countBall(userInputList, answer);
                decision.referee(countStrike, countBall);

                if(countStrike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }

            } catch (IllegalArgumentException e) {
                throw new IllegalStateException("입력값이 잘못되었습니다. 게임을 종료합니다.");
            }

        }
    }
}
