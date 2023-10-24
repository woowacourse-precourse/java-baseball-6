package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class NumberHandler {

    private static final String NUMBER_COUNT_EXCEPTION = "숫자 개수가 부정확합니다";
    private static final String NUMBER_RANGE_EXCEPTION = "숫자 범위가 부정확합니다";
    private static final String NUMBER_DUP_EXCEPTION = "숫자가 중복됩니다";

    private final int countOfNumbers;

    public NumberHandler(int countOfNumbers){
        this.countOfNumbers = countOfNumbers;
    }

    public List<Integer> generateRandomNumberList(){

        List<Integer> randArrList = new ArrayList<>();
        int cur = 0;
        int randNum;

        while(cur < countOfNumbers){
            randNum = Randoms.pickNumberInRange(1,9);

            if(!randArrList.contains(randNum)) {
                randArrList.add(randNum);
                cur++;
            }
        }
//        System.out.print("생성된 숫자: ");
//        for(Integer i : randArrList){
//            System.out.print(i+" ");
//        }
//        System.out.println();
        return randArrList;
    }

    public List<Integer> inputUserNumbers(){

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        if(userInput.length() < countOfNumbers) throw new IllegalArgumentException();

        List<Integer> numbersList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            int number = Character.getNumericValue(c);
            if(number < 1 || number > 9) throw new IllegalArgumentException();
            numbersList.add(number);
        }
        boolean hasDuplicates = numbersList.stream()
                .distinct()
                .count() != numbersList.size();
        if(hasDuplicates) throw new IllegalArgumentException();
        return numbersList;
    }
}
