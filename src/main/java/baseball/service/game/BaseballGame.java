package baseball.service.game;

import baseball.domain.output.OutPutView;
import baseball.domain.output.Output;
import baseball.service.calculator.BaseballCalculator;
import baseball.domain.computer.ComputerNumber;
import baseball.domain.input.Input;
import baseball.domain.input.InputView;
import baseball.dto.Result;
import baseball.util.message.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements GameInterface{
    private static final int TARGET_NUMBER = 3;
    private static final int REPLAY_NUMBER = 1;
    private static final int QUIT_NUMBER = 2;
    private final Input input;
    private final Output output;

    public BaseballGame() {
        this.input = new InputView();
        this.output = new OutPutView();
    }

    @Override
    public void play() {
        PrintMessage.startGameMessage();
        ComputerNumber computerNumber = new ComputerNumber();
        while (true){
            int[] inputNumber = input.execute();
            Result result = BaseballCalculator.calculateBallAndStrike(computerNumber, inputNumber);
            output.execute(result);
            if(result.getStrikeCount()==TARGET_NUMBER){
                break;
            }
        }
        wannaPlayOrQuit();
    }

    private void wannaPlayOrQuit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer decision = Integer.valueOf(Console.readLine());
        if(decision==REPLAY_NUMBER){
            play();
        }
        if(decision==QUIT_NUMBER){
            
        }
    }
}
