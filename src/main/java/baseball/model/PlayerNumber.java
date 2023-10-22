package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {
    public String playerNumber;

    public PlayerNumber(String playerNumber){
        isNumberLengthCorrect(playerNumber);
        isNumberDifferent(playerNumber);
        isDigitPlayerNumber(playerNumber);

        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber(){
        return playerNumber;
    }

    public static void isNumberLengthCorrect(String inputNumber) throws IllegalArgumentException{
        if(inputNumber.length()!=3){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리수 입력)");
        }
    }

    public static void isNumberDifferent(String inputNumber) throws IllegalArgumentException{
        Set<Character> set= new HashSet<>();
        for(int i=0;i<inputNumber.length();i++){
            set.add(inputNumber.charAt(i));
        }
        if(set.size()!=3){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
        }
    }

    public static void isDigitCharInString(String inputNumber, int index) throws IllegalArgumentException{
        if(!Character.isDigit(inputNumber.charAt(index))){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리의 자연수)");
        }
    }

    public static void isDigitPlayerNumber(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            isDigitCharInString(inputNumber, i);
        }
    }

    // 입력된 플레이어 넘버가 적합한가 체크
        // 중복된 숫자가 없는지 확인하는 메서드
        // 세자리 숫자가 맞는지 확인하는 메서드
        // 자연수가 맞는지 확인하는 메서드

}
