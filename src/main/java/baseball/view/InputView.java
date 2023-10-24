package baseball.view;

import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class InputView {
    public InputView(){}

    public static void inputNumber(List<Integer> computer){
        BaseballController controller = new BaseballController(computer);
        System.out.print("숫자를 입력해주세요 : ");
        String[] input = Console.readLine().split("");

        List<Integer> user = new ArrayList<>();
        for(int i=0; i<3; i++) {
            int number = Integer.parseInt(input[i]);
           user.add(number);
        }

        controller.check(computer,user);
    }
}
