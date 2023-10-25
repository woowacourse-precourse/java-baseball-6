package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private static final int length = 3;
    private static final int startNum = 1;
    private static final int endNum = 9;
    private List<Integer> userNumber;
    public UserNumber(String userNumber){
        validateAll(userNumber);
        this.userNumber = toInteger(userNumber);
    }
    public List<Integer> toInteger(String str){
        List<Integer> userNumber = new ArrayList<>();
        for(String s : str.split("")){
            userNumber.add(Integer.parseInt(s));
        }
        return userNumber;
    }
    public List<Integer> getUserNumber(){
        return userNumber;
    }

    public static void validateAll(String numbers){
        validateType(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
        validateLength(numbers);
    }

    public static void validateRange(String numbers){
        for(int i=0; i<numbers.length(); i++){
            if(numbers.charAt(i)-'0'<startNum || numbers.charAt(i)-'0'>endNum){
                throw new IllegalArgumentException();

            }
        }
    }
    public static void validateType(String str) {
        for(char c : str.toCharArray()){
            if(c=='0'){
                throw new IllegalArgumentException();
            }
        }
    }
    public static void validateLength(String numbers) {
        if(numbers.length() != length){
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicated(String numbers){
        boolean arr[] = new boolean[10];
        for(int i=0; i<numbers.length(); i++) {
            int num = numbers.charAt(i) - '0';
            if (arr[num]) {
                throw new IllegalArgumentException();
            }
            arr[num] = true;
        }
    }



}
