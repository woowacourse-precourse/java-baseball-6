package baseball;

import static baseball.status.GameMsg.GAME_OVER;
import static baseball.status.GameMsg.REPLAY_OR_OVER_MESSAGE;
import static baseball.status.GameMsg.SET_INPUT;
import static baseball.status.GameMsg.SUCCESS_MESSAGE;
import static baseball.status.GameSetting.OVER;
import static baseball.status.GameSetting.REPLAY;

import baseball.game.GameInput;
import baseball.game.GameOutput;
import baseball.game.GameUtil;
import java.util.ArrayList;
import java.util.List;

class Game {
    private final GameInput gameInput;
    private final GameOutput gameOutput;
    private final GameUtil gameUtil;

    Game(GameInput gameInput, GameOutput gameOutput, GameUtil gameUtil) {
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
        this.gameUtil = gameUtil;
    }

    public void play() {
        List<Integer> computerNum = gameUtil.setComputerNum();
        List<Integer> inputNum = new ArrayList<>();

        while (!inputNum.equals(computerNum)) {
            gameOutput.printMessage(SET_INPUT.getMsg());

            String input = gameInput.setInput();
            inputNum = gameInput.getIntegerInput(input);

            int[] result = gameUtil.calculateResult(computerNum, inputNum);
            gameOutput.output(result);
        }
        handleGameChoice();
    }

    /**
     * 게임 재시작, 종료 여부
     */
    public void handleGameChoice() {
        gameOutput.printMessage(SUCCESS_MESSAGE.getMsg());
        gameOutput.printMessage(REPLAY_OR_OVER_MESSAGE.getMsg());
        String input = gameInput.setInput();
        String choice = gameInput.getReplayOrOverInput(input);
        replayOrOver(choice);
    }

    /**
     * 종료 여부에 따른 게임 재시작, 게임 종료
     *
     * @param choice 종료 여부
     */
    private void replayOrOver(String choice) {
        if (choice.equals(REPLAY.getStringValue())) {
            play();
        } else if (choice.equals(OVER.getStringValue())) {
            gameOutput.printMessage(GAME_OVER.getMsg());
            gameInput.close();
        }
    }
}
