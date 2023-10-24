package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Baseball baseball;
    private final Score score;

    private Integer gameFlag;
    public Game() {
        this.baseball = new Baseball();
        this.score = new Score();
        this.gameFlag = 1;
    }

    public void play() {


        while (gameFlag == 1) {
            List<Integer> computer = getRandomNum();
            while (true) {
                List<Integer> human = baseball.getUserNum();
                int strike = score.countStrike(computer, human);
                int ball = score.countBall(computer, human);
                score.getResult(strike, ball);
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameFlag = Integer.parseInt(Console.readLine());
        }


    }

    public List<Integer> getRandomNum() {
        List<Integer> RandomNumList = new ArrayList<>();
        while (RandomNumList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!RandomNumList.contains(randomNum)) {
                RandomNumList.add(randomNum);
            }
        }
        return RandomNumList;

    }




}
