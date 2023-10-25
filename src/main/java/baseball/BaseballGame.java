package baseball;


import static baseball.utils.SystemOutPut.printScoreMsg;

import baseball.utils.NumberCompare;
import baseball.utils.SystemOutPut;
import baseball.utils.SystemSetting;
import baseball.validation.InputValidation;
import java.util.List;

public class BaseballGame {
    private InputValidation validation = new InputValidation();
    private SystemSetting setting = new SystemSetting();
    private NumberCompare comapre = new NumberCompare();
    public List<Integer> computer;


    public boolean reStart(boolean threeStrike) {
        if (!threeStrike && validation.endInput().equals("1")) {
            computer = setting.getRandamNumber();
            return true;
        }
        if (!threeStrike) {
            return false;
        }
        return true;
    }


    public void startGame() {
        int[] count = new int[2];
        SystemOutPut.printStartMsg();
        computer = setting.getRandamNumber();
        boolean threeStrike = true;
        while (threeStrike) {
            SystemOutPut.printInputMsg();
            List<Integer> user = validation.startInput();
            comapre.compareNumber(computer, user, count);
            printScoreMsg(count);
            threeStrike = setting.checkStrikeCount(count);
            threeStrike = reStart(threeStrike);
        }
    }
}
