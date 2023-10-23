package baseball;
import java.util.List;
public class Application {
    public static void main(String[] args) {

        boolean playerWantToPlay = true;

        while(playerWantToPlay) {

            List<Integer> computer;
            List<Integer> player;
            BaseballFunction baseballFunction = new BaseballFunction();
            Score score = new Score(0, 0);

            System.out.println("숫자 야구 게임을 시작합니다.");

            computer = baseballFunction.genNum();

            while (score.strike != 3){
                player = baseballFunction.getNum();
                score = baseballFunction.compare(computer, player);
                baseballFunction.printScore(score);
            }

            playerWantToPlay = baseballFunction.threeStrike();

        }
    }
}
