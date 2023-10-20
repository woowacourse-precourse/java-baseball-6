package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
    private boolean endOrNot = true;
    public Game(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(endOrNot) {
            startGame();
            exitGame();
        }
        System.out.println("게임 종료");
    }

    public void startGame(){
        Computer computer = new Computer();
        List<Integer> computerNumber = computer.getComputerNumber();
        while(true) {
            User user = new User();
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> userNumber = parsingInputNumber(InputView.Input());
            List<Integer> gameResult = playGame(computerNumber, userNumber);
            if(OutputView.outputResult(gameResult))
                break;
        }
    }

    public ArrayList<Integer> parsingInputNumber(String inputNumber){
        // TODO : Parsing 쉽게 하는 방법 찾기; 예외 처리 Exception class 따로 만들어서 빼기
        if(inputNumber.length() != 3)
            throw new IllegalArgumentException();
        ArrayList<Integer> parsingNumber = new ArrayList<>();
        for(int i = 0; i < inputNumber.length(); i++){
            char parsedChar = inputNumber.charAt(i);
            if(!(parsedChar > '0')){
                throw new IllegalArgumentException();
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

    public List<Integer> playGame(List<Integer> computerNumber, List<Integer> userNumber){
        // TODO : 알고리즘적으로 개선의 여지가 있는 지 검토하기
        int strike = 0;
        int ball = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(computerNumber.get(i).equals(userNumber.get(i))){
                strike++;
            }else if(computerNumber.contains(userNumber.get(i))){
                ball++;
            }
        }
        result.add(strike);
        result.add(ball);
        return result;
    }
}
