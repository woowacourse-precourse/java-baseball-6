package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {

    private String playerNumber;

    public PlayerNumber(String playerNumber){//토탈



        Length(playerNumber);
        Digit(playerNumber);
        Overlap(playerNumber);

        this.playerNumber = playerNumber;//매개변수로 받은 것을 할당!

    }
    //////////////////////////
    public String getPlayerNumber(){
        return playerNumber;
    }

    //매개변수 Stirng number 입력된값 저장
    public static void Length(String number)throws IllegalArgumentException{
        if(number.length() != 3){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.3자리숫자를 정확히 입력하였는지 확인해보세요");
        }

    }
    public static void Digit(String number){
        for (int i = 0; i < number.length(); i++) {
            DigitString(number,i);
        }

    }

    public static void Overlap(String number)throws IllegalArgumentException{
        Set<Character> set = new HashSet<>();//Set은 객체를 중복해서 저장할 수 없고 하나의 null만 저장
        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }
        if (set.size() != number.length()){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.중복된 값이 있는지 확인해보세요");
        }
    }
    public static void DigitString(String number, int index)throws IllegalArgumentException{
        if (!Character.isDigit(
                number.charAt(index))){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.자연수인지 확인하세요");
        }
    }
}
