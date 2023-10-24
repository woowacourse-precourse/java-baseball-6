package baseball.user;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private final List<Integer> user; //다른거랑 연관을 받지 않게끔 하기 위해
    private final static String numberE = "[ERROR] 문자를 입력 하였습니다.";
    private final static String numberLength = "[ERROR] 세자리의 숫자만 입력 하세요.";
    private final static String numberEqauls = "[ERROR] 다른 세자리의 수를 입력 하세요.";
    public User(){
        this.user = parseInt(userValue());
    }

    public String userValue(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }

    public List<Integer> parseInt(String input) {
        List<Integer> user = new ArrayList<>();
        String[] userSplit = input.split("");

        for (String str : userSplit) {
            try {
                int number = Integer.parseInt(str); // 숫자로 변환
                user.add(number);
            } catch (NumberFormatException e) {
                // 잘못된 숫자 형식 처리
                throw new IllegalArgumentException(numberE);
            }
        }

        if(user.size() != 3){
            throw new IllegalArgumentException(numberLength); //세자리의 숫자가 아닐경우
        }

        if(user.size() != user.stream().distinct().count()){
            throw new IllegalArgumentException(numberEqauls);
        }

        return user; //user값 반환

    }

    public List<Integer> getUser(){
        return user; //반환받을 값을 알기 위해서
    }
}