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
}