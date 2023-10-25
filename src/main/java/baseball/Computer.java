package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNum;

    public Computer(){
        computerNum = new ArrayList<>();
    }

    public List<Integer> getComputerNum(){
        createComputerNum();
//        try{
//            validateRangeForAll();
//            validateSize();
//        }catch (IllegalArgumentException e){
//            getComputerNum();
//        }
        return computerNum;
    }
    public void createComputerNum() {
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 13);
            if(!computerNum.contains(randomNumber)){
                computerNum.add(randomNumber);
            }
        }
    }

    public void validateRangeForAll(){
        for(int elem : computerNum){
            validateRange(elem);
        }
    }

    public void validateRange(int num){
        if(num < 1 || num > 9){
            throw new IllegalArgumentException("숫자는 1~9범위이여야 합니다.");
        }
    }

    public void validateSize(){
        if(computerNum.size() != 3){
            throw new IllegalArgumentException("3자리 수 숫자여야 합니다.");
        }
    }
}
