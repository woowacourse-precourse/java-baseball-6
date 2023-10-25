package baseball.model;

import baseball.validator.ComputerValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/*
 * 컴퓨터 난수 생성 로직
 * */
public class ComputerNumber {
    private List<Integer> computerNumberList;

    public ComputerNumber(){
        generateRandomNumber();

        ComputerValidator.isNumberDuplicated(computerNumberList);
        ComputerValidator.isNumberSizeCorrect(computerNumberList);
        ComputerValidator.isNumberDuplicated(computerNumberList);
    }

    //난수를 반환하는 메서드
    public List<Integer> getComputerNumber(){
        return computerNumberList;
    }

    //서로 다른 난수 3개를 무작위로 생성한 후 computerNumberList에 저장 -> 중복 숫자 방지
    public void generateRandomNumber(){
        computerNumberList = new ArrayList<>();
        while(computerNumberList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumberList.contains(randomNumber)){
                computerNumberList.add(randomNumber);
            }
        }
    }

    //난수 리셋 메서드
    public void reset(){
        generateRandomNumber();
    }

}
