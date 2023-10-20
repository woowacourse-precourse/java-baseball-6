package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Play {

    private final User user;
    private final Computer com;
    private final Rules rules;
    private String input;

    public Play() {
        user = new User();
        com = new Computer();
        rules = new Rules();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        com.getIntArray();
    }

    public void getInput(String msg) {
        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
    }

    public void RestartOrFinishGame() {

    }

    public void runGame() {

    }
}
