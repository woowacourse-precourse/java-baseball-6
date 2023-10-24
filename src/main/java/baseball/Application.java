package baseball;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static Validator validator = new  Validator();
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        do {
            gm.execute();
        } while(isContinue() != 2);
    }

    public static int isContinue()  {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        validator.systemInput(input);

        return Integer.valueOf(input);
    }
}
