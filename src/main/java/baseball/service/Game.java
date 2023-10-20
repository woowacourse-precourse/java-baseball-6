package baseball.service;

import baseball.domain.User;
import baseball.view.InputView;

import java.util.ArrayList;

public class Game {
    public Game(){
        startGame();
    }

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            User user = new User();
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> numbers = parsingInputNumber(InputView.InputNumber());
        }
    }

    public ArrayList<Integer> parsingInputNumber(String inputNumber){
        // TODO : Parsing 쉽게 하는 방법 찾기
        ArrayList<Integer> parsingNumber = new ArrayList<>();
        for(int i = 0; i < inputNumber.length(); i++){
            char parsedChar = inputNumber.charAt(i);
            try{
                int number = Integer.parseInt(String.valueOf(parsedChar));
                parsingNumber.add(number);
            }catch (NumberFormatException e){
                System.out.println("Parsing error " + parsedChar);
            }
        }

        return parsingNumber;
    }

}
