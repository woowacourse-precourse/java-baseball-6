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

    public static void check_Numsize(List<Number> User_num) {
        //List의 크기가 3이상이면 예외처리
        if(User_num.size() != Constant.MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void is_Duplicate(List<Number> User_num){
        //중복된 숫자가 있다면 예외처리
        if(User_num.size() != User_num.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static void exit_error_check(int exit_num) {
        if(exit_num != Constant.EXIT_NUMBER && exit_num != Constant.RESTART_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
