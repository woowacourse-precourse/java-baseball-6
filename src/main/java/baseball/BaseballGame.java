package baseball;


import baseball.utils.SystemOutPut;
import baseball.utils.SystemSetting;
import baseball.validation.InputValidation;
import java.util.List;

public class BaseballGame {
    private InputValidation validation = new InputValidation();
    private SystemSetting setting = new SystemSetting();
    public List<Integer> computer;


    public void reStart(boolean threeStrike) {
        if (!threeStrike && validation.endInput().equals("1")) {
            computer = setting.getRandamNumber();
            System.out.println(computer.toString());
        }
    }

    public void startGame() {
        SystemOutPut.printStartMsg();
        setting.getRandamNumber();
        computer = setting.getRandamNumber();
        int[] count = new int[2];
        boolean threeStrike = true;
        while (threeStrike) {

            SystemOutPut.printInputMsg();
            List<Integer> user = validation.startInput();
            
            //랜덤값 입력값이랑 비교

            // 스트라이크, 볼 결과 출력 해주기

            threeStrike = setting.checkStrikeCount(count);
            reStart(threeStrike);
        }


    }
}
