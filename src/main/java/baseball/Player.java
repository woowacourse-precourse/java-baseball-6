package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> playerNumber(){
        System.out.println("숫자를 입력해주세요");
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        try {
            예외_테스트(userInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Integer> playerNum = 입력값_리스트_반환(userInput);
        return playerNum;
    }
    static void 예외_테스트(String 입력값) throws IllegalArgumentException{
        boolean exceptionTnf = true;
        //4. 3자리 이상 입력햇을 때 Exception
        if(입력값.length() != 3){
            exceptionTnf = false;
            throw new IllegalArgumentException("3자리 입력해주셔야합니다.");
        }
        exceptionTnf = 입력값_문자열포함_체크(입력값);

    }
    //4. 3자리 입력이지만 문자열이 포함되어 있을 때 Exception
    static boolean 입력값_문자열포함_체크(String 입력값) throws IllegalArgumentException{
        try {
            Integer.parseInt(입력값);
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }
    static List<Integer> 입력값_리스트_반환(String 입력값){
        List<Integer> userInputList = new ArrayList<>();
        userInputList.add(Integer.parseInt(입력값.substring(0,1)));
        userInputList.add(Integer.parseInt(입력값.substring(1,2)));
        userInputList.add(Integer.parseInt(입력값.substring(2)));
        return userInputList;
    }
}
