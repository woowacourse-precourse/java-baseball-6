package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.exception.NumberException.*;

public class NumberHandler {

    private final int countOfNumbers;
    List<Integer> randArrList;

    public NumberHandler(int countOfNumbers){
        this.countOfNumbers = countOfNumbers;
    }

    public List<Integer> generateRandomNumberList(){

        randArrList = new ArrayList<>();
        int cur = 0;
        int randNum;

        while(cur < countOfNumbers){
            randNum = Randoms.pickNumberInRange(1,9);

            if(!randArrList.contains(randNum)) {
                randArrList.add(randNum);
                cur++;
            }
        }
        return randArrList;
    }

    public List<Integer> inputUserNumbers(){

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        if(userInput.length() > countOfNumbers) throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION.getErrorMsg());

        List<Integer> numbersList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            int number = Character.getNumericValue(c);
            if(number < 1 || number > 9) throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION.getErrorMsg());
            numbersList.add(number);
        }
        boolean hasDuplicates = numbersList.stream()
                .distinct()
                .count() != numbersList.size();
        if(hasDuplicates) throw new IllegalArgumentException(NUMBER_DUP_EXCEPTION.getErrorMsg());
        return numbersList;
    }

    // print generated rand number
    public void printRandNum(){
        System.out.print("생성된 숫자: ");

        for(Integer i : this.randArrList){
            System.out.print(i+" ");
        }

        System.out.println();
    }
}
