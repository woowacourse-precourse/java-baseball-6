package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    public static void checkIfRightInput(String input){
        CheckIfRightInput checkIfRightInput = new CheckIfRightInput(input);
    }

    // 서로 다른 숫자 3개를 만드는 함수
    public static String makeAnswer() {
        Set<Integer> answerSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (answerSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            answerSet.add(randomNumber);
        }

        for (int a : answerSet) {
            sb.append(a);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String answer = makeAnswer();

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            checkIfRightInput(input);
            System.out.println(answer);
            Score score = Game.calScore(answer, input);

            if (score.strikeScore == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int order = Integer.parseInt(Console.readLine());
                if (order == 1) {
                    answer = makeAnswer();
                }else if (order == 2) {
                    break;
                }
            } else {
                if (score.strikeScore == 0 && score.ballScore == 0) {
                    System.out.println("낫싱");
                } else if(score.strikeScore == 0) {
                    System.out.println(score.ballScore + "볼");
                } else if (score.ballScore == 0) {
                    System.out.println(score.strikeScore + "스트라이크");
                } else if (score.strikeScore > 0 && score.ballScore > 0){
                    System.out.println(score.ballScore + "볼 " + score.strikeScore + "스트라이크");
                }
            }

        }


    }
}
