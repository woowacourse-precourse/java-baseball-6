package baseball.service;

import java.util.List;

public class GameService {
    public int strikeResult(List<Integer> computer, List<Integer> player){
        int result = 0;

        for (int i=0; i<computer.size(); i++){
            Integer computerBall = computer.get(i);
            Integer playerBall = player.get(i);
            if (computerBall.equals(playerBall)) result += 1;
        }

        return result;
    }

    public int ballResult(List<Integer> computer, List<Integer> player){
        int strike = strikeResult(computer, player);

        computer.retainAll(player);

        return computer.size() - strike;
    }
}
