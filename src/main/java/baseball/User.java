package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;

public class User {
    private ArrayList<Integer> guessNumber; //유저가 선택한 숫자
    User(){
        this.guessNumber=new ArrayList<>();
    }

    public ArrayList<Integer> getNumbers() {
        return this.guessNumber;
    }

    public void setGuessNumber(){
        String numbers = Console.readLine();
        if(numbers.length()!=3){ //입력한 숫자가 3개가 아닐시 IllegalArgumentExpection 발생 후 프로그램 종료
            throw new IllegalArgumentException();
        }
        else{ //숫자3개가 맞다면
            for(int i=0; i< numbers.length();i++){
                char c = numbers.charAt(i);
                this.guessNumber.add(c-'0'); //아스키코드를 이용한 정수 변환
            }
            HashSet<Integer>checkDuplication = new HashSet<>(guessNumber); //중복된 숫자가 있는지 확인하기 위한 set자료형
            if(checkDuplication.size()!=guessNumber.size()){ //중복된 숫자가 있으면 두 자료형의 크기가 다름
                throw new IllegalArgumentException(); //오류 발생
            }
        }
    }

    public void clearGuessNumber(){ //guessNumber를 초기화하는 메소드
        this.guessNumber.clear();
    }
}
