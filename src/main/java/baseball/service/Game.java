package baseball.service;

import baseball.domain.User;
import baseball.view.InputView;

import java.util.ArrayList;

public class Game {
    private boolean endOrNot = true;
    public Game(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(endOrNot) {
            startGame();
            exitGame();
        }
        System.out.println("게임 종료!");
    }

    public void startGame(){
        while(true) {
            User user = new User();
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> numbers = parsingInputNumber(InputView.Input());
        }
    }

    public ArrayList<Integer> parsingInputNumber(String inputNumber){
        // TODO : Parsing 쉽게 하는 방법 찾기; 예외 처리 Exception class 따로 만들어서 빼기
        if(inputNumber.length() > 3)
            throw new IllegalStateException();
        ArrayList<Integer> parsingNumber = new ArrayList<>();
        for(int i = 0; i < inputNumber.length(); i++){
            char parsedChar = inputNumber.charAt(i);
            if(!(parsedChar > '0')){
                throw new IllegalStateException();
            }
            try{
                int number = Integer.parseInt(String.valueOf(parsedChar));
                parsingNumber.add(number);
            }catch (NumberFormatException e){
                System.out.println("Parsing error " + parsedChar);
            }
        }

        return parsingNumber;
    }

    public void exitGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(InputView.Input().equals("2")){
            this.endOrNot = false;
        }
    }
}
