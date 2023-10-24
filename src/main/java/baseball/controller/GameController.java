package baseball.controller;

import baseball.service.InputService;
import baseball.service.PrintService;
import baseball.util.Converter;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.GameConstant.*;

public class GameController {
    private final int[] answer;
    private final int size;
    private final int start;
    private final int end;
    private final int exit;
    private final int restart;

    public GameController(int[] answer, int size, int start, int end, int exit, int restart) {
        this.answer = answer;
        this.size=size;
        this.start=start;
        this.end=end;
        this.exit=exit;
        this.restart=restart;
    }

    public void startGame() {
        String resultMessage;
        do {
            System.out.print(INPUT_PROMPT);
            String input = InputService.getNumber(size,start,end);
            resultMessage = PrintService.printResult(answer, Converter.convertToArray(input));
            System.out.println(resultMessage);
        } while (!resultMessage.contains(GAME_OVER));
    }

    public boolean restartOrExit() {
        System.out.println(RESTART_OR_EXIT_PROMPT);
        String input= Console.readLine();
        return InputService.restart(input, restart,exit);
    }
}
