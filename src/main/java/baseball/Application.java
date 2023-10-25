package baseball;

import baseball.controller.BasicController;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int nextNum = 1;
        BasicController controller = new BasicController();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(nextNum != 2){
            controller.createComputerNumber();

            while(nextNum != 2){
                System.out.print("숫자를 입력해주세요 : ");
                String userNum = Console.readLine();

                if(userNum.length() > 3)
                    throw new IllegalArgumentException("입력이 올바르지 않습니다.");

                if(controller.checkNumber(userNum)) {
                    String nextStep = Console.readLine();
                    nextNum = Integer.parseInt(nextStep);
                    break;
                }

            }

        }
    }
}
