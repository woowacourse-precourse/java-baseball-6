package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Game {

    RandomNumber randomNumber = new RandomNumber();
    int start = 1;
    List<Integer> userInputList = new ArrayList<>(3);
    String[] inputs = new String[3];
    Decision decision = new Decision();

    public void play() {

        List<Integer> answer = randomNumber.createRandomNumber();

        while(start != 2) {
            System.out.print("숫자를 입력해주세요 : ");

            try {
                String inputNumber = Console.readLine();
                if(inputNumber.length() != 3) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자를 입력하세요.");
                }

                inputs = inputNumber.split("");

                for(int i=0; i<3; i++) {
                    userInputList.add(i, parseInt(inputs[i]));
                }

                int countStrike = decision.countStrike(userInputList, answer);
                int countBall = decision.countBall(userInputList, answer);
                decision.referee(countStrike, countBall);

                if(countStrike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    start = parseInt(Console.readLine());

                    if(start == 1) {
                        answer = randomNumber.createRandomNumber();
                    }
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("입력값이 잘못되었습니다. 게임을 종료합니다.");
            }

        }
    }
}
