package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserBalls {
    public List<Integer> inputBalls(){
        System.out.println("숫자를 입력하세요 :");

        List<Integer> userBalls = new ArrayList<>();
        String inputBall = Console.readLine();

        if (inputBall.length() >= 4) {
            throw new IllegalArgumentException("3자리의 숫자를 입력하세요.");
        }

        for(int i=0; i< inputBall.length(); i++){
            userBalls.add(Integer.parseInt(String.valueOf(inputBall.charAt(i))));
        }

        return userBalls;
    }

}
