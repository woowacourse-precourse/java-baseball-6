package baseball;
import baseball.controller.Controller;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;


public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
//        int i = Randoms.pickNumberInRange(1,9);
//        System.out.println(i);
    }
}
