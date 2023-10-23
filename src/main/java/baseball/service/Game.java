package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        // 예외 처리 Exception class 고려해 보기
        if(inputNumber.length() != 3)
            throw new IllegalArgumentException();
        ArrayList<Integer> parsingNumber = new ArrayList<>();

        for(char parsedChar : inputNumber.toCharArray()){
            if(parsedChar < '1'){
                throw new IllegalArgumentException();
            }
            int number = Character.getNumericValue(parsedChar);
            parsingNumber.add(number);
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
        long strike = (int)IntStream.range(0, 3)
                .filter(i -> computerNumber.get(i).equals(userNumber.get(i)))
                .count();

        long ball = (int)IntStream.range(0, 3)
                .filter(i -> !computerNumber.get(i).equals(userNumber.get(i)) && userNumber.contains(computerNumber.get(i)))
                .count();

        return List.of((int)strike, (int)ball);
    }
}
