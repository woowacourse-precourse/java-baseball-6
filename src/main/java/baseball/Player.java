package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> guessNumbers = new ArrayList<>();

    public Player(){
    }

    public void inputNumber(){
        guessNumbers.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String guessNumber = Console.readLine();
        if (guessNumber.length() != 3) throw new IllegalArgumentException();
        for (char c : guessNumber.toCharArray() ){
            this.guessNumbers.add(Character.getNumericValue(c));
        }
    }

    public List<Integer> getGuessNumbers() {
        return guessNumbers;
    }

}
