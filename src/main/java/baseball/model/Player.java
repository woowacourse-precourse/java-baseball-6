package baseball.model;
/*
 * 사용자로 부터 입력 받음 & 오류메세지 출력
 * */

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String Player;
    char tmp;

    //값을 입력받는다.
    public String getInputNumber() {
        return Player;
        //return Console.readLine();
    }

    public Player(String Player){
        length_Correct(Player);
        number_dup(Player);

        number_int(Player,tmp);

        this.Player = Player;
    }

    //IllegalArgumentException 이용
    //3자리 수인지 Len확인
    public static void length_Correct(String pNum)throws IllegalArgumentException{
        if (pNum.length() != 3){
            throw new IllegalArgumentException("3자리수를 입력해주세요.");
        }
    }
    //중복된 값인지
    public static void number_dup(String pNum)throws IllegalArgumentException{
        Set<Character> set = new HashSet<>();
        for (int i=0;i<pNum.length();i++){
            set.add(pNum.charAt(i));

        }
        if (pNum.length() != 3){
            throw new IllegalArgumentException("중복된 값을 입력했습니다.");
        }
    }
    //숫자인지_내장함수 isDigit사용
    public static void number_int(String pNum, char tmp)throws IllegalArgumentException{
        for (int i =0 ; i<pNum.length(); i++){
            tmp = pNum.charAt(i);

            if (!Character.isDigit(tmp)){
                throw new IllegalArgumentException("자연수가 아닙니다. 자연수를 입력해주세요.");
            }
        }

    }
}
