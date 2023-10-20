package baseball.service.game;

import baseball.service.output.OutPutView;
import baseball.service.output.Output;
import baseball.service.calculator.BaseballCalculator;
import baseball.domain.computer.ComputerNumber;
import baseball.service.input.Input;
import baseball.service.input.InputView;
import baseball.dto.Result;
import baseball.service.calculator.Calculate;
import baseball.util.error.ErrorMessage;
import baseball.util.message.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements GameInterface{
    private static final int TARGET_NUMBER = 3;
    private static final int REPLAY_NUMBER = 1;
    private static final int QUIT_NUMBER = 2;

    // 전략 패턴, 구성을 이용해서 변화할 수 있는 부분은 관심사를 인터페이스로 떼어낸다.
    private final Input input;
    private final Output output;
    private final Calculate calculate;

    public BaseballGame() {
        this.input = new InputView();
        this.output = new OutPutView();
        this.calculate = new BaseballCalculator();
    }

    @Override
    public void play() {
        PrintMessage.startGameMessage();
        ComputerNumber computerNumber = new ComputerNumber();
        playingGame(computerNumber);
        wannaPlayOrQuit();
    }

    private void playingGame(final ComputerNumber computerNumber) {
        while (true){
            int[] inputNumber = input.execute();
            Result result = calculate.calculateBallAndStrike(computerNumber, inputNumber);
            output.execute(result);
            if (isWin(result)) break;
        }
    }

    private static boolean isWin(final Result result) {
        if(isStrikeTargetNum(result)){
            return true;
        }
        return false;
    }

    private static boolean isStrikeTargetNum(Result result) {
        return result.getStrikeCount() == TARGET_NUMBER;
    }

    private void wannaPlayOrQuit() {
        PrintMessage.wannaPlayOrQuitMessage();
        int decision = Integer.parseInt(Console.readLine());
        isValidNum(decision);
        isReplay(decision);
        isQuit(decision);
    }

    private static void isValidNum(int decision) {
        if(isNotOne(decision) && isNotTwo(decision)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_DECISION.toString());
        }
    }

    private static boolean isNotTwo(int decision) {
        return decision != 2;
    }

    private static boolean isNotOne(int decision) {
        return decision != 1;
    }

    private static void isQuit(final int decision) {
        if(decision == QUIT_NUMBER){

        }
    }

    private void isReplay(final int decision) {
        if(decision ==REPLAY_NUMBER){
            play();
        }
    }
}
