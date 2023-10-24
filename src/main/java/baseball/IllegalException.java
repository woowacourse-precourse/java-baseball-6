package baseball;

public class IllegalException {
    public static void illegalInput(String input){
        int test = Integer.parseInt(input);;
        if(input.length()!=3){
            throw new IllegalArgumentException("입력한 자리수가 3자리가 아닙니다.");
        }
        try {
            int a = Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            throw e;
        }
    }
}
