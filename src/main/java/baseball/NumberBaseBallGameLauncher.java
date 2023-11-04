package baseball;

import baseball.enums.GameFlag;
import baseball.enums.GameProgressMessage;
import baseball.enums.OrNot;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class NumberBaseBallGameLauncher implements GameLauncher{

    private GameFlag flag = GameFlag.START;
    private Computer computer = new Computer();
    private Judgement judgement = new Judgement();

    @Override
    public void startGame() {
        PrintMessage.printlnMessage(GameProgressMessage.START);
        initGame();
    }

    @Override
    public void initGame() {
        if(flag == GameFlag.START){
            GameInputValue gameValue = new GameInputValue(computer.createGameValue());
            flag = GameFlag.ING;
            play(gameValue);
        }

    }

    @Override
    public void endGame() {}

    @Override
    public void play(GameInputValue gameValue) {
        if (flag == GameFlag.ING) {
            PrintMessage.printMessage(GameProgressMessage.INPUT_NUMBER);
            gameValue.setUserInputValue(readLine());
            judgement.judge(gameValue);

            // 리플레이 또는 종료
            if(isWin(gameValue)){
                PrintMessage.printlnMessage(GameProgressMessage.PLAY_NEXT_GAME_OR_NOT);
                replayOrEnd();

                if (flag == GameFlag.START) {
                    initGame();
                }

                if (flag == GameFlag.END) {
                    endGame();
                }

                return;
            }
            play(gameValue);
        }
    }

    public boolean isWin(GameInputValue gameValue) {
        return gameValue.isEqaulsUserAndComputerValue();
    }

    public void replayOrEnd() {
        String answer = readLine();
        if (answer.equals(OrNot.YES.getProcessCode())) {
            flag = GameFlag.START;
        }
        if (answer.equals(OrNot.NO.getProcessCode())) {
            flag = GameFlag.END;
        }
    }

}
