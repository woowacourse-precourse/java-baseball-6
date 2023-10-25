package baseball.controller;

import baseball.entity.Computer;
import baseball.entity.Hint;
import baseball.entity.User;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_SHUTDOWN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static Computer pc;
    public static User user;
    public static Hint hint;

    public BaseballGameController(){
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

//        while (true) {
            System.out.print(INPUT_MESSAGE);
            pc = new Computer();
            pc.setNumber();

            user = new User();
            user.setNumber(Console.readLine());

            /*
                 4. 숫자 판별
                    a. 같은 자리, 같은 숫자 -> 스트라이크
                    b. 다른 자리, 같은 숫자 -> 볼
                    c. 다른 자리, 다른 숫자 -> 낫싱
            */
            hint = new Hint();
            hint.gamePlay(pc.getNumber(), user.getNumber());
//        }
    }
}
