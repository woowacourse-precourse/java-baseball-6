package baseball.controller;

import baseball.service.InputService;
import baseball.service.PrintService;
import baseball.util.Converter;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final int[] answer;
    private final int size;

    public GameController(int[] answer, int size) {
        this.answer = answer;
        this.size=size;
    }

    public void startGame() {
        String resultMessage;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = InputService.getNumber(size);
            resultMessage = PrintService.printResult(answer, Converter.convertToArray(input));
            System.out.println(resultMessage);
        } while (!resultMessage.contains("게임 종료"));
    }

    public boolean restartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input= Console.readLine();
        return InputService.restart(input, 1,2);
    }
}
