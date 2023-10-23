package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    List<Integer> numbers;
    Numbers(){
        numbers = new ArrayList<>();
        setRandomNumbers();
    }
    Numbers(NumberInput numberInput){
        numbers = new ArrayList<>();
        initNumbers(numberInput);
    }
    private void initNumbers(NumberInput numberInput){
        for(int i = 0; i < 3; i++){
            int number = numberInput.getNumberByIndex(i);
            validateDuplicatedNumber(number);
            numbers.add(number);
        }
    }
    private void setRandomNumbers(){
        boolean[] visitedNumberArray = new boolean[10];
        while(numbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(checkDuplicated(visitedNumberArray, randomNumber)) continue;
            numbers.add(randomNumber);
        }
    }
    private boolean checkDuplicated(boolean[] duplicateCheck, int num){
        if(duplicateCheck[num]) return true;
        duplicateCheck[num] = true;
        return false;
    }
    public void validateDuplicatedNumber(int number){
        if(numbers.contains(number)){
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요");
        }
    }
    public int getNumberByIndex(int index){
        return numbers.get(index);
    }
}
