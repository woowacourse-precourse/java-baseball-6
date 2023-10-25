package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;

    private List<Integer> numbers ;
    public User(){
        this.numbers= new ArrayList<>();
    }
    public void inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        for (char c : inputString.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        if(numbers.size() != BASEBALL_GAME_NUMBER_LENGTH){
            throw new IllegalArgumentException("Input must be an 3digit integer.");
        }
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            for (int j = 0; j < i; j++) {
                if(numbers.get(j) == numbers.get(i)) {
                    //유저가 입력한 i인덱스에 들어갈 숫자가 중복된 숫자인지 확인
                    throw new IllegalArgumentException("Do not input duplicate numbers.");
                }
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
