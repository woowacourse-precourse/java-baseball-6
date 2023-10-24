package baseball;

import baseball.dto.Computer;
import baseball.dto.Player;
import baseball.dto.Result;
import baseball.service.Converter;
import baseball.service.GameLogic;
import baseball.service.ResultPrint;
import baseball.service.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자 야구가 실행 되는 클래스
 */
public class Application {
    static final String RESTART = "1";
    static final String END = "2";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            Computer computer = new Computer();
            Player player = new Player();
            Result result = new Result();
            Validation validator = new Validation();
            while (result.isStatus() == Result.WRONG) {
                System.out.print("숫자를 입력해주세요 : ");
                String num = Console.readLine();
                validator.validate(num);
                player.setInput(num);
                player.setPlayerNumberBall(Converter.convert(player.getInput()));

                GameLogic logic = new GameLogic();
                logic.play(player.getPlayerNumberBall(), computer.getComputerNumberBall(), result);
                new ResultPrint(result).print();
                logic.resultClear(result);
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            player.setCondition(Console.readLine());
            validator.validateForRestart(player.getCondition());

            if (player.getCondition().equals(END)) {
                break;
            }
        }
        Console.close();
    }
}
