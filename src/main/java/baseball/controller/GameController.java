package baseball.controller;

import baseball.domain.GameService;
import baseball.util.Parser;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    GameService service = new GameService();
    Parser parser = new Parser();
    Validator validator = new Validator();
    List<Integer> computerNumbers = new ArrayList<>();

    private static final String EXIT = "2";
    private static final String MSG_START = "숫자 야구 게임을 시작합니다.";
    private static final String MSG_QUERY = "숫자를 입력해주세요.";
    private static final String MSG_GAMEOVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MSG_ASK_IF_CONTINUES = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String MSG_EXCEPTION_INVALID_INPUT = "올바르지 않은 입력값입니다.";
    private static boolean playing = true;

    private void init() {
        computerNumbers.clear();
    }

    public void play() {
        System.out.println(MSG_START);
        while (playing) {
            if (computerNumbers.isEmpty()) computerNumbers = service.generateNumbers();
            System.out.println(MSG_QUERY);
            List<Integer> userNumbers = receiveInput();
            int[] result = service.compare(computerNumbers, userNumbers);
            service.printResult(result);
            if(service.isThreeStrikes(result)){
                System.out.println(MSG_GAMEOVER);
                System.out.println(MSG_ASK_IF_CONTINUES);
                String restartInput = Console.readLine();
                determineRestart(restartInput);
            }
        }
    }

    private List<Integer> receiveInput(){
        String input = Console.readLine();
        List<Integer> userNumbers = parser.parseInputToList(input);
        if (validator.isInvalid(userNumbers)) throw new IllegalArgumentException(MSG_EXCEPTION_INVALID_INPUT);
        return userNumbers;
    }

    private void determineRestart(String restartInput) {
        if (validator.isInvalid(restartInput)) throw new IllegalArgumentException(MSG_EXCEPTION_INVALID_INPUT);
        init();
        if(restartInput.equals(EXIT)) playing = false;
    }
}
