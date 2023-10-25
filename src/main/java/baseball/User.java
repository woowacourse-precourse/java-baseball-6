package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    // - 사용자 숫자 입력 : 서로 다른 3자리의 수이다.
    //-- 예외) 잘못된 값일 경우 IllegalArgumentException을 발생 후 종료.
    //   1. [x] 사용자 입력 숫자 3개를 리스트에 분리하여 저장한다.
    //   2. [x] 중복된 숫자가 있는지 확인한다.
    //   3. [x] 이때 3글자가 아니거나, 중복일 경우, 글자 혹은 소수 같은 예외가 발생할 경우 에러를 발생한다.
    //   4. [x] 종료 여부 선택 : 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수만 입력가능하다.
    String number;
    public List<Integer> inputNumber(){
        String number = Console.readLine();
        return makeListNumber(number);
    }
    public void setNumber(String number){
        String userNumber = this.number;

    }
    public List<Integer> makeListNumber(String userNumber){
        List<Integer> userList = new ArrayList<>();
        try{
            for (int i = 0; i < userNumber.length(); i++) {
                userList.add(Integer.parseInt(userNumber.substring(i,i+1)));
            }
            checkNumber(userList);

            return userList;
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("숫자만 입력하세요");
        }

    }
    public void checkNumber(List<Integer> userList){
        if(userList.size()!=3){
            throw new IllegalArgumentException("3자리의 숫자를 입력하세요.");
        }
        for (int i = 0; i < userList.size()-1; i++) {
            int checkedNum=userList.get(i);
            if(Collections.frequency(userList,checkedNum)!=1){
                throw new IllegalArgumentException("중복된 숫자를 입력하지 마세요.");
            }
            if(!(1<=checkedNum && checkedNum <=9)){
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해야합니다.");
            }

        }

    }
    public boolean inputRestart(){
        String userNumber = Console.readLine();
        if (userNumber.equals("1")){
            return true;
        } else if (userNumber.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1과 2중의 숫자를 입력해야합니다.");
        }
    }
}
