package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserInputNumber {
    private List<Integer> userNumber;

    public List<Integer> getUserNumber(){
        return this.userNumber;
    }
    public void inputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        this.userNumber=new ArrayList<>();
        String input = Console.readLine();
        for(int idx=0;idx<input.length();idx++){
            userNumber.add(Character.getNumericValue(input.charAt(idx)));
        }
    }
    public void numberValidCheck(int size){
        HashSet<Integer> set = new HashSet<>();
        if(userNumber.size()!=size){
            throw new IllegalArgumentException("length is different from expected");
        }
        for (int idx=0;idx<size;idx++) {
            int num=userNumber.get(idx);
            if (!(1<=num && num <=9)) {
                throw new IllegalArgumentException("value not in range.");
            }
            if (set.contains(num)){
                throw new IllegalArgumentException("duplicate number.");
            }
            else{
                set.add(num);
            }
        }
    }
}
