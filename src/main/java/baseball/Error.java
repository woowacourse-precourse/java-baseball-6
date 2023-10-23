package baseball;

import java.util.List;

public class Error {
    //숫자인지 아닌지 확인하는 예외처리
    public static boolean is_Not_number(String str) {
        try{
            Integer.parseInt(str);
            return false;
        } catch (IllegalArgumentException e){
            return true;
        }
    }

    //숫자지만 잘못된 값 또는 잘못된 개수 또는 중복된 숫자를 입력한 예외처리
    public static void check_Numsize(List<Number> User_num) {
        //List의 크기가 3이상이면 예외처리
        if(User_num.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void is_Duplicate(List<Number> User_num){
        //중복된 숫자가 있다면 예외처리
        if(User_num.size() != User_num.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
