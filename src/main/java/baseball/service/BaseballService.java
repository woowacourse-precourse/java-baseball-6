package baseball.service;

import baseball.domain.BallCount;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {
    private static final int BASEBALL_SIZE =3;

    //컴퓨터가 생각하는 3개의 랜덤 수 (1~9)
    public static List<Integer> createRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }




    public static void baseballGame(User user, Computer computer, BallCount ballCount) {
        for(int i = 0 ; i < BASEBALL_SIZE;i++){
            if(user.getBaseball().get(i) == computer.getBaseball().get(i)){
                ballCount.setStrike();
                continue;
            }
            if(computer.getBaseball().contains(user.getBaseball().get(i))){
                ballCount.setBall();
            }
        }
        OutputView.nowBallCount(ballCount.getBallCount());


    }
}
