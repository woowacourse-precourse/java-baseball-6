package baseball;

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
}
