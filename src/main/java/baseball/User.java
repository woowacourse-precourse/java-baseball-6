package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class User {
    // 일급 콜렉션이란, 콜렉션을 포함한 클래스는 반드시 다른 멤버 변수가 없어야 한다. 여기선 입력에 대한 배열을 만들지 말자 아직 적용 안함
    String input;
    List<Integer> inputList;
    public User() throws IllegalArgumentException{
        try{
            this.input = Console.readLine();
            validateLength(this.input);
            validateCharacter(this.input);
            inputList = new ArrayList<Integer>();
            validateDuplication(this.input, this.inputList);
        } catch (IllegalArgumentException e){
            throw e;
        }


    }

    private void validateLength(String input) throws IllegalArgumentException{
        if(input.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    private void validateCharacter(String input) throws IllegalArgumentException {
        for(int i = 0; i < 3; i++){
            char character = input.charAt(i);
            if(!('1' <= character && character <= '9')){
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplication(String input, List<Integer> inputList) throws IllegalArgumentException{
        for(int i = 0; i < 3; i++){
            int number = (int) (input.charAt(i) - '0');
            if(inputList.contains(number)){
                throw new IllegalArgumentException();
            }
            inputList.add(number);
        }
    }

}
