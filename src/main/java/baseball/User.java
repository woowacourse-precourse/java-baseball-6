package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
public class User {
    String userNumber;
    List<Integer> userNumberList = new ArrayList<>();
    int isExit = 3;

    public void setNumber(){ // 사용자가 숫자를 입력하는 함수
        System.out.print("숫자를 입력해주세요 : ");
        userNumber = Console.readLine();
        if(userNumber.length() != 3){
            throw new IllegalArgumentException();
        }
        userNumberList.clear();
        for(int i = 0; i < userNumber.length(); i++){
            char c = userNumber.charAt(i);
            int intValue = Character.getNumericValue(c);
            userNumberList.add(intValue);
        }
    }

    public void isAgain(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        isExit = Integer.parseInt(Console.readLine());
        if(isExit != 1 && isExit != 2){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
