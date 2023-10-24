package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 9;
    private static final int CNT_INPUT = 3;


    List<Integer> input(){
        System.out.print("숫자를 입력해주세요 : ");
        String user = Console.readLine();
        checkType(user);
        checkLength(user);
        checkDuplication(user);
        checkMinAndMax(user);
        return stringToList(user);
    }

    void checkLength(String user){
        if(user.length() != CNT_INPUT) throw new IllegalArgumentException(String.format("%d자리 숫자를 입력해주세요", CNT_INPUT));
    }

    void checkMinAndMax(String user){
        for(int i = 0; i<user.length(); i++){
            int inputChar = Integer.parseInt(user.substring(i,i+1));
            if(inputChar < MIN_INPUT || inputChar > MAX_INPUT) {
                throw new IllegalArgumentException(String.format("각 자리수는 %d부터 %d까지의 숫자로만 입력해주세요.", MIN_INPUT, MAX_INPUT));
            }
        }
    }

    void checkDuplication(String user){
        Set<Character> set = new HashSet<>();
        for(char c : user.toCharArray()){
            if(set.contains(c)) throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            set.add(c);
        }
    }

    void checkType(String user){
        try{
            Integer.parseInt(user);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    List<Integer> stringToList(String input){
        List<Integer> list = new ArrayList<>();
        String[] arr = input.split("");
        for(String s : arr) list.add(Integer.parseInt(s));
        return list;
    }
}
