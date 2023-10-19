package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.GameConstant.*;

public class Game {
    List<Integer> randomNumber = new ArrayList<>();

    private void createRandomNumber(){
        randomNumber.clear();
        while (randomNumber.size() < RANDOM_NUMBER_SIZE) {
            int intRandomNumber = Randoms.pickNumberInRange(START_RANGE, LAST_RANGE);
            if (!randomNumber.contains(intRandomNumber)) {
                randomNumber.add(intRandomNumber);
            }
        }
    }

    private void userInput(){
        System.out.printf(INPUT_NUMBER);
        String inputStringNumber = Console.readLine();
    }

    private void errorValidate(String stringNumber) throws IllegalAccessException {
        if (!stringNumber.matches(REGULAR_EXPRESSION_NUMBER)){
            throw new IllegalAccessException();
        }
    }

    private List<Integer> stringToIntegerList(String stringNumber)  {
        List<Integer> inputNumber = new ArrayList<>();
        for(char charNumber : stringNumber.toCharArray()){
            inputNumber.add(Character.getNumericValue(charNumber));
        }
        return inputNumber;
    }

    private void inputValidate(List<Integer> number){

    }




}
