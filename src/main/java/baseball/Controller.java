package baseball;

import baseball.domain.Computer;
import baseball.domain.Manager;
import baseball.domain.Referee;
import baseball.util.Converter;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Controller {

    public static final int SIZE = 3;
    Validator validator = new Validator();
    Converter converter;
    Computer computer = new Computer(SIZE);
    Referee referee;
    Manager manager;


    public void run() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validator.checkValid(input, SIZE);
        converter = new Converter(input);
        List<Integer> computerNumbers = computer.getComputerNumbers();
        List<Integer> userNumbers = converter.getSeperatedNumbers();
        referee = new Referee(computerNumbers, userNumbers);
        System.out.println(referee.getJudgement());
        if (referee.getStrike() != 3) {
            run();
        }
        if (referee.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            manager = new Manager(Console.readLine());
            if (manager.getResult().equals("재시작")) {
                run();
            }
        }
    }
}
