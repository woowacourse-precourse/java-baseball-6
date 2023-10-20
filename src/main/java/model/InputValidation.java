package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    public void gameNumValidation(List<Integer> inputNum){
        Set<Integer> set = new HashSet<>(inputNum);

        try{
            if(inputNum.size()!=3) throw new IllegalArgumentException("3자리 수를 입력해야합니다.");

            if(inputNum.size()!=set.size()) throw new IllegalArgumentException("각각 다른 숫자를 입력해주세요.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
    public void coinValidation(int coin) {
        try {
            if (coin != 1 && coin != 2) throw new IllegalArgumentException("1또는 2를 입력하세요.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
