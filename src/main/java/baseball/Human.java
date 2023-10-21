package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private List<Integer> human;
    private final CheckException checkException;
    public Human(){
        this.human = new ArrayList<>();
        this.checkException = new CheckException();
    }
    // 사용자에게 값을 입력 받기
    public void chooseValues() {
        System.out.print("숫자를 입력해주세요. : ");
        String inputValue = Console.readLine();
        checkException.checkValueInGame(inputValue);
        human.clear();
        char[] values = inputValue.toCharArray();
        for(char value : values){
            human.add(Character.getNumericValue(value));
        }
    }
    public List<Integer> getHuman(){
        return human;
    }

    public boolean isRestart() {
        String valueRestart = Console.readLine();
        checkException.checkValueRestart(valueRestart);
        int choice = Integer.parseInt(valueRestart);
        return choice == 1;
    }
}
