package baseball;

import baseball.core.Core;
import baseball.model.Score;
import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallGame {
    Core core = new Core();
    public void run(){
        BaseBallGame game = new BaseBallGame();
        Score score = new Score();
        List<Integer> computerNumber = Utils.computerCreateNumber();

        while (score.getStrikes() != 3){
            List<Integer> userNumber = game.setUserNumber();
            counting(userNumber,computerNumber,score);
            core.jugement(score.getTotal(),score.getStrikes(), score.getBalls());
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

    public void counting(List<Integer> userNumber, List<Integer> computerNumber,Score score){
        int total = core.countAll(userNumber,computerNumber);
        int strikes = core.countStrike(userNumber,computerNumber);
        score.setCount(total,strikes);
    }



}
