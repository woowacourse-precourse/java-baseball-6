package baseball.service;

import baseball.controller.BallDto;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public int strikeResult(List<BallDto> computer, List<BallDto> user){
        int result = 0;
        for (int i=0; i<computer.size(); i++){
            BallDto computerBall = computer.get(i);
            BallDto userBall = user.get(i);
            if (computerBall.getNumber().equals(userBall.getNumber())) result += 1;
        }
        return  result;
    }

    public int ballResult(List<BallDto> computer, List<BallDto> user){
        int strike = 0;
        List<Integer> computerList = new ArrayList<>();
        List<Integer> userList = new ArrayList<>();

        for (int i=0; i<computer.size(); i++){
            Integer computerNum = computer.get(i).getNumber();
            Integer userNum = user.get(i).getNumber();
            computerList.add(computerNum);
            userList.add(userNum);
            if (computerNum.equals(userNum)) strike += 1;
        }
        computerList.retainAll(userList);
        return computerList.size() - strike;
    }
}
