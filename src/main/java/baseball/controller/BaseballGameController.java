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
        user = new User();
        hint = new Hint();
        pc = new Computer();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initializePc();

        while (true) {
            System.out.print(INPUT_MESSAGE);

            user = new User();
            user.setNumber(Console.readLine());

            hint = new Hint();

            hint.gamePlay(pc.getNumber(), user.getNumber());
            hint.printHint();

            if(hint.getGameOver()) {
                System.out.println(RESTART_OR_SHUTDOWN_MESSAGE);
                if(Console.readLine().equals("1")){
                    initializePc();
                }else break;
            }
        }
        Console.close();
    }

    public void initializePc(){
        pc = new Computer();
    }
}
