package baseball.domain;

import baseball.service.InputService;
import baseball.service.PrintService;

import static baseball.constant.GameConstant.*;

public class GameSetting {
    private final int size;
    private final int startNum;
    private final int endNum;
    private final int exitNum;
    private final int restartNum;
    private final InputService inputService;
    private final PrintService printService;

    public GameSetting(int size, int startNum, int endNum, int exitNum, int restartNum, InputService inputService, PrintService printService) {
        this.size = size;
        this.startNum = startNum;
        this.endNum = endNum;
        this.exitNum = exitNum;
        this.restartNum = restartNum;
        this.inputService = inputService;
        this.printService = printService;
    }

    public int getSize() {
        return size;
    }

    public int getStartNum() {
        return startNum;
    }

    public int getEndNum() {
        return endNum;
    }

    public int getExitNum() {
        return exitNum;
    }

    public int getRestartNum() {
        return restartNum;
    }

    public InputService getInputService() {
        return inputService;
    }

    public PrintService getPrintService() {
        return printService;
    }
}