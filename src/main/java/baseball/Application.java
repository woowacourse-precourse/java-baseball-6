package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        boolean flag = true;
        Run.start();
        List<Integer> computerNumber = Run.createNum();
        try {
            while (flag) {
                List<Integer> personNumber = Run.userTurn();

                if (!Run.judge(computerNumber, personNumber)) {
                    flag = Run.end();
                    if (flag) {
                        computerNumber = Run.createNum();
                    }
                }
            }
        } finally {
            Console.close();
        }
    }
}
