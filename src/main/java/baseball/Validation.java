package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Validation {
    public List<Integer> getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        boolean validate = checkValidate(userInput);
        if(validate){
            return Converter.convert2Int(userInput);
        }
        else{
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public boolean checkValidate(String value){
        if(value.length() == 3) {
            try {
                int number = Integer.parseInt(value);
                return number >= 100 && number <= 999;
            } catch (NumberFormatException e){
                return false;
            }
        }
        return false;
    }
}
