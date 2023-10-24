package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args){

        Message message = new Message();
        Validation validation = new Validation();
        Computer computer = new Computer();
        User user = new User();

        message.play();

        while (true) {

            List<Integer> random = computer.random();

            while (true) {

                message.input();

                String[] number = user.number(); // 사용자 입력 번호

                validation.exception(number); // 유효성 검사

                Map<String, Integer> countMap = computer.count(random, number);

                System.out.println(computer.check(countMap.get(Const.BALL), countMap.get(Const.STRIKE)));

                if (countMap.get(Const.STRIKE) == 3) break;
            }

            message.end();

            message.restartOrExit();

            String choice = user.check();

            if (choice.equals(Const.RESTART_NUMBER));
            else if (choice.equals(Const.EXIT_NUMBER)) break;
            else throw new IllegalArgumentException();
        }
    }
}
