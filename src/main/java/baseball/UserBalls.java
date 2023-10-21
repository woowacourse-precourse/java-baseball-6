package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserBalls {
    public List<Integer> makeUserBalls(){
        System.out.println("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> userBallsList = new ArrayList<>();
        String userValue = scanner.next();

        for(String value : userValue.split("")){
            userBallsList.add(Integer.parseInt(value)); //String 타입을 Integer타입으로 형변환
        }

        return userBallsList;
    }

}
