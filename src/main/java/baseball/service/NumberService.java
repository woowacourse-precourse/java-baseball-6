package baseball.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberService {
    public List<Integer> setUserNumber(){
        String number = Console.readLine();

        checkInputNumber(number);

        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void checkInputNumber(String input){
        /* 숫자 판별 */
        for (int i=0;i<3;i++) {
            try{
                Integer.parseInt(input);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException();
            }
        }
        /* 길이 판별 */
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        /* 중복 판별 */
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0;i<3;i++) {
            if (numbers.contains(Character.getNumericValue(input.charAt(i)))){
                throw new IllegalArgumentException();
            }
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        /* 0 판별 */
        if (input.contains("0")){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> setRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
