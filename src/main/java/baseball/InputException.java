package baseball;

import java.util.List;

public class InputException {

    public void checkInput(String input){
        BaseballGame baseballGame = new BaseballGame();
        checkSize(input);
        checkZero(input);
    }

    public void checkSize(String input){
        boolean check = false;
        if (input.length() != 3){
            check = true;
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
    }

    public void checkZero(String input){

        BaseballGame baseballGame = new BaseballGame();
        List<Integer> inputNumber = baseballGame.StringToIntList(input);


        for(int i = 0; i < inputNumber.size(); i++){
            System.out.println(inputNumber.get(i));
            if(inputNumber.get(i).equals(0)){
//                throw new IllegalArgumentException("0은 입력이 불가능합니다.");
            }
        }
    }
}
