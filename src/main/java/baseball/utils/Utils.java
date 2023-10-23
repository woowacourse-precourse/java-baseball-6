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
        validateStringLength(userNumber,3);
        validateStringNaturalNumber(userNumber);
        int number = Integer.parseInt(userNumber);
        return intToIntList(number);
    }

    // 에러처리 메서드
    //1. 올바른 숫자가 아닌경우
    public static void validateStringNaturalNumber(String input){
        for (char c: input.toCharArray()){
            if(!Character.isDigit(c) || c == '0'){
                throw new IllegalArgumentException("올바른 숫자가 아닙니다. 게임을 종료합니다.");
            }
        }
    }


    //2. 자릿수가 맞지 않은 경우
    public static void validateStringLength(String input, int length){
        if(input.length() != length){
            throw new IllegalArgumentException("올바른 길이로 입력해주세요. 게임을 종료합니다.");
        }
    }

    //3. 중복숫자가 포함된 경우
    public static void validateAllDifferentNumber(String input){
        List<Character> list = input.chars().mapToObj(c->(char)c).collect(Collectors.toList());
        HashSet<Character> set = new HashSet<>(list);
        if (set.size() != input.length()){
            throw new IllegalArgumentException("중복된 숫자가 포함되어있습니다. 프로그램을 종료합니다.");
        }
    }

    //4. 사용자 재시작 버튼 에러처리
    public static void validateRestartNumber(String input){
        if(!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException("1,2 중 하나를 입력해주세요. 게임을 종료합니다.");
        }
    }


}
