package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    //User의 숫자값 입력해서 List형으로 리턴
    public static List<Integer> User(){
        String num_str = Console.readLine();
        char[] num_ch = num_str.toCharArray();

        if(is_Not_number(num_str)) {
            throw new IllegalArgumentException();
        }

        String[] token = num_str.split("");

        List<Integer> User_num = new ArrayList<>();

        for(int i = 0 ; i < token.length ; i++){
            User_num.add(Integer.parseInt(token[i]));
        }

        is_illegal(User_num);
        return User_num;
    }

    //숫자인지 아닌지 확인하는 예외처리
    public static boolean is_Not_number(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch(IllegalArgumentException e) {
            return true;
        }
    }

    //숫자지만 잘못된 값 또는 잘못된 개수 또는 중복된 숫자를 입력한 예외처리
    public static void is_illegal(List<Integer> User_num) {
        //List의 크기가 3이상이면 예외처리
        if(User_num.size() != 3) {
            throw new IllegalArgumentException();
        }

        //중복된 숫자가 있다면 예외처리
        if(User_num.size() != User_num.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}