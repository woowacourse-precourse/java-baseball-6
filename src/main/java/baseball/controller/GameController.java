package baseball.controller;

import baseball.domain.GameService;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameController {

    GameService service = new GameService();

    public void start() {
        List<Integer> computerNumbers = service.generateNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요.");
        String input = Console.readLine();
        List<Integer> userNumbers = service.parseInputToList(input);
        int[] result = service.compare(computerNumbers, userNumbers);
    }
}
