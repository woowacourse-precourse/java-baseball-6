package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

public class UserBalls {
    public List<Integer> makeUserBalls(){
        System.out.println("숫자를 입력해주세요 : ");

        String userValue = Console.readLine();
        List<Integer> userBallsList = new ArrayList<>();


        for(String value : userValue.split("")){
            userBallsList.add(Integer.parseInt(value)); //String 타입을 Integer타입으로 형변환
        }

        return userBallsList;
    }

}
