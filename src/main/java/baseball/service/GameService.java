package baseball.service;

import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameService {
    private static boolean endOrNot = true;
    public static void startGame(){
        initStartGame();
        while(endOrNot) {
            startOneGame();
            exitGame();
        }
        System.out.println("게임 종료");
    }

    public static void startOneGame(){
        Computer computer = new Computer();
        boolean oneGameFinished = false;
        List<Integer> computerNumber = computer.getComputerNumber();
        while(!oneGameFinished) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = parsingInputNumber(InputView.Input());
            List<Integer> gameResult = playGame(computerNumber, userNumber);
            if(OutputView.outputResult(gameResult))
                oneGameFinished = true;
        }
    }

    public static List<Integer> parsingInputNumber(String inputNumber){
        // 예외 처리 Exception class 고려해 보기
        if(inputNumber.length() != 3)
            throw new IllegalArgumentException();
        ArrayList<Integer> parsingNumber = new ArrayList<>();

        for(char parsedChar : inputNumber.toCharArray()){
            if(Character.isDigit(parsedChar)){
                int number = Character.getNumericValue(parsedChar);
                if(number <= 0)
                    throw new IllegalArgumentException();
                parsingNumber.add(number);
            }
            if(!Character.isDigit(parsedChar)){
                throw new IllegalArgumentException();
            }
        }
        return parsingNumber;
    }

    public static void exitGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(InputView.Input().equals("2")){
            endOrNot = false;
        }
    }

    public static List<Integer> playGame(List<Integer> computerNumber, List<Integer> userNumber){
        long strike = (int)IntStream.range(0, 3)
                .filter(i -> computerNumber.get(i).equals(userNumber.get(i)))
                .count();

        long ball = (int)IntStream.range(0, 3)
                .filter(i -> !computerNumber.get(i).equals(userNumber.get(i)) && userNumber.contains(computerNumber.get(i)))
                .count();

        return List.of((int)strike, (int)ball);
    }

    public static void initStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        endOrNot = true;
    }
}
