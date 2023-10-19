package baseball.controller;

import baseball.domain.ComputerNum;
import baseball.domain.EnterNum;
import baseball.validator.ResultValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final EnterNum enterNum;
    private ResultValidator resultValidator;

    public GameController() {
        this.enterNum = new EnterNum();
        this.resultValidator = new ResultValidator(new ComputerNum());
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            enterNum.setNum(Console.readLine());
            enterNum.validation();

            resultValidator.enterCheckNum(enterNum);

            if (resultValidator.checkResult()) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int checkOver = Integer.parseInt(Console.readLine());

                if (checkOver == 2) {
                    break;
                } else if (checkOver == 1) {
                    resultValidator = new ResultValidator(new ComputerNum());
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
