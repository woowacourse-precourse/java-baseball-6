package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Number {
    Number(String number){
        this.number = this.toArrayList(number);
    }
    public ArrayList<Integer> number;
    private ArrayList<Integer> toArrayList(String number){
        checkValidity(number);
        ArrayList<Integer> numberArray = new ArrayList<>();
        String[] s = number.split("");
        for(int i=0;i<3;i++){
            numberArray.add(Integer.parseInt(s[i]));
        }
        return numberArray;
    }
    public void checkValidity(String str){
        try{
            Integer.parseInt(str);
        } catch (NumberFormatException e){
            error();
        }
        if(str.length()!=3){
            error();
        }
    }
    public void checkRedundancy(){
        Set<Integer> set = new HashSet<>();
        for(int i : this.number){
            if(set.contains(i)){
                error();
            } else {
                set.add(i);
            }
        }
    }
    public static void error(){
        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }
}
