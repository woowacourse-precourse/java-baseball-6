package baseball;

import baseball.core.Core;
import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallGame {
    public static void run(){
        BaseBallGame game = new BaseBallGame();
        Core core = new Core();
        List<Integer> computerNumber = Utils.computerCreateNumber();

        String strikeAndBall = "";
        while (!strikeAndBall.equals("3스트라이크")){
            List<Integer> userNumber = game.setUserNumber();
            strikeAndBall = core.jugement(userNumber,computerNumber);
            System.out.println(strikeAndBall);
        }
    }

    public List<Integer> setUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        Utils.validateStringNaturalNumber(userNumber);
        Utils.validateStringLength(userNumber,3);
        Utils.validateAllDifferentNumber(userNumber);
        int number = Integer.parseInt(userNumber);
        return Utils.intToIntList(number);
    }

}
