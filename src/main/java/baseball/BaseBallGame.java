package baseball;

import java.util.List;

enum STAGES {
    START,
    PLAY,
    END,
    OVER,
}

public class BaseBallGame implements Game {
    private STAGES stage;
    private Computer computer;
    private final BaseBallGameInput baseBallGameInput;

    BaseBallGame() {
        this.baseBallGameInput = new BaseBallGameInput();
        this.start();
    }

    private void start() {
        this.stage = STAGES.START;
        this.printStageMessage();
        this.computer = new Computer(new NextStepRandomNumberGenerator());
        System.out.println(this.computer.getComputerNumbers());
    }

    @Override
    public void play() {
        this.stage = STAGES.PLAY;
        this.printStageMessage();

        List<Integer> inputNumbers = this.baseBallGameInput.playInput();
        String result = this.computer.guessNumber(inputNumbers);
        System.out.println(result);
        if (result.equals(GameConstant.GAME_END_CONDITION)) {
            this.end();
        }
    }

    private void end() {
        this.stage = STAGES.END;
        this.printStageMessage();

        String input = this.baseBallGameInput.endInput();
        if (input.equals(GameConstant.END_STAGE_RESTART)) {
            this.start();
            return;
        }

        if (input.equals(GameConstant.END_STAGE_GAME_OVER)) {
            this.stage = STAGES.OVER;
        }
    }

    private void printStageMessage() {
        if (this.stage == STAGES.START) {
            System.out.println(GameConstant.START_STAGE_MESSAGE);
            return;
        }

        if (this.stage == STAGES.PLAY) {
            System.out.print(GameConstant.PLAY_STAGE_MESSAGE);
            return;
        }

        if (this.stage == STAGES.END) {
            System.out.println(GameConstant.END_STAGE_MESSAGE);
            System.out.println(GameConstant.END_STAGE_MESSAGE2);
        }
    }


    @Override
    public boolean isGameOver() {
        return this.stage == STAGES.OVER;
    }
}
