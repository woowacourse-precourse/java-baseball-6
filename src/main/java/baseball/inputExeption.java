package baseball;

public class inputExeption {
    public static boolean isUnigueInput(String[] input){
        int cnt;
        for(String num:input){
            cnt=0;
            for(String compare_num:input){
                if (num.equals(compare_num)){
                    cnt++;
                }
            }
            if (cnt>1){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public static boolean isDigitNumber(String[] input){
        if(input.length !=BaseballGame.listSize){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isOneAndTwoNumber(String input){
        if(!(input.equals("1") || input.equals("2"))){
            throw new IllegalArgumentException();
        }
        return true;
    }
}