package baseball.view;

import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ResultView {

    public static void printResult(int[] result, List<Integer> computer) {
        BaseballController controller = new BaseballController(computer);

        if(result[0]==0 && result[1]==0){
            System.out.println("낫싱");
            InputView.inputNumber(computer);
        }
        else if(result[0]==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input = Integer.parseInt(Console.readLine());
            controller.restart(input);
        }
        else if(result[0]==0){
            System.out.println(result[1] + "볼 ");
            InputView.inputNumber(computer);
        }
        else if(result[1]==0){
            System.out.println(result[0] + "스트라이크 ");
            InputView.inputNumber(computer);
        }

        else{
            System.out.println(result[1] + "볼 "+ result[0] + "스트라이크 ");
            InputView.inputNumber(computer);
        }

    }
}
