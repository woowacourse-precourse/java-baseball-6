package baseball;

import baseball.view.PlayerInput;
import baseball.view.PlayerOutput;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static baseball.view.PlayerInput.inputNums;
import static baseball.view.PlayerInput.isExitGame;

public class Application {
    public static ValidateNumbers getComputerValue() {
        int randomNumber = Randoms.pickNumberInRange(100, 999);
        ValidateNumbers computer;
        try {
            computer = new ValidateNumbers(Integer.toString(randomNumber));
        } catch (IllegalArgumentException e) {
            computer = getComputerValue();
        }
        return computer;
    }

    public static void validatenumber클래스_확인용() {
        //test for validatenumbers
        try {
            ValidateNumbers temp = new ValidateNumbers("113");
        } catch (ThreeDigitException e) {
            System.out.println(e.getMessage());
        } catch (RangeException e) {
            System.out.println(e.getMessage());
        } catch (DifferentEachOtherException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("finish!");

    }

    public static void main(String[] args) {
        PlayerOutput.gameStartMsg();
        while(true) {
            //한 라운드

            //컴퓨터 숫자 설정
            ValidateNumbers computer = getComputerValue();
            //System.out.println(computer);

            while(true) {
                PlayerOutput.numInputMsg();
                ValidateNumbers player = inputNums();
                PlayerOutput.gameResult(computer, player);
                if(GameJudge.isGameFinish(computer, player)){
                    break;
                }
            }

            PlayerOutput.gameFinishMsg();
            PlayerOutput.restartMsg();
            if(isExitGame())
                break;
        }


    }
}
