package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> input(){
        System.out.print("숫자를 입력해주세요 : ");
        String user = Console.readLine();
        inputValid(user);
        return stringToList(user);
    }

    void inputValid(String user) throws IllegalArgumentException {
        if(user.length() != 3) throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        if(user.charAt(0) == user.charAt(1) || user.charAt(0) == user.charAt(2) || user.charAt(1) == user.charAt(2)) throw new IllegalArgumentException("중복 숫자 입력");
        if(isNum(user) == false) throw new IllegalArgumentException("숫자를 입력해주세요.");
        if(user.contains("0")) throw new IllegalArgumentException("1~9까지의 숫자만 입력해주세요.");
    }

    boolean isNum(String user){
        try{
            Integer.parseInt(user);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    List<Integer> stringToList(String input){
        List<Integer> list = new ArrayList<>();
        String[] arr = input.split("");
        for(String s : arr) list.add(Integer.parseInt(s));
        return list;
    }
}
