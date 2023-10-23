package baseball.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<Integer> computerCreateNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    // int -> intList
    public static List<Integer> intToIntList(int number){
        List<Integer> numberList = new ArrayList<>();
        while(number > 0){
            int digit = number % 10;
            numberList.add(0,digit);
            number /= 10;
        }
        return numberList;
    }

    // 사용자 숫자 입력받기
    public static List<Integer> inputUserNumber(){
        String userNumber = Console.readLine();
        // 에러처리
        int number = Integer.parseInt(userNumber);
        return intToIntList(number);
    }


}
