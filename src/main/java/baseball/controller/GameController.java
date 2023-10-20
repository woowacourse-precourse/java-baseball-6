package baseball.controller;

import baseball.domain.GameService;
import baseball.utill.Parser;
import baseball.utill.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    GameService service = new GameService();
    Parser parser = new Parser();
    Validator validator = new Validator();
    List<Integer> computerNumbers = new ArrayList<>();

    private static final String RESTART = "1";
    private static final String EXIT = "2";

    private void init() {
        computerNumbers.clear();
    }

    public void start() {
        while (true) {
            if (computerNumbers.isEmpty()) computerNumbers = service.generateNumbers();
            System.out.println("숫자를 입력해주세요.");
            String input = Console.readLine();
            List<Integer> userNumbers = parser.parseInputToList(input);
            if (validator.isInvalid(userNumbers)) throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
            int[] result = service.compare(computerNumbers, userNumbers);
            service.printResult(result);
            if(service.isThreeStrikes(result)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restartInput = Console.readLine();
                if(restartInput.equals(RESTART)) init();
                if(restartInput.equals(EXIT)) return;
            }

        }
    }
}
