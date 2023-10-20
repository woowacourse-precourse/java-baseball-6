package baseball.controller;

import baseball.domain.GameService;
import baseball.utill.Validation;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameController {

    GameService service = new GameService();
    Validation validation = new Validation();

    public void start() {
        List<Integer> computerNumbers = service.generateNumbers();
        System.out.println("치트: " + computerNumbers.get(0) + computerNumbers.get(1) + computerNumbers.get(2));
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요.");
        String input = Console.readLine();
        List<Integer> userNumbers = service.parseInputToList(input);
        if(validation.isInvalid(userNumbers)) throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
        int[] result = service.compare(computerNumbers, userNumbers);
        service.printResult(result);
    }
}
