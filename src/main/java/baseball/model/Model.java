package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static List<Integer> getRandomList(int length){
        List<Integer> randomList = new ArrayList<>();

        while (randomList.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }

        return randomList;
    }

    public boolean printAndGetResult(String stringOfNum, List<Integer> randomList){
        int strike=0, ball=0;

        for (int i=0 ; i<stringOfNum.length() ; i++){
            int currentInt = stringOfNum.charAt(i)-'0';

            if(randomList.contains(currentInt)){
                if(randomList.get(i)==currentInt)
                    strike++;
                else
                    ball++;
            }
        }

        if (strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }
        else{
            System.out.println(ball+"볼 " + strike + "스트라이크");
            return false;
        }
    }

}
