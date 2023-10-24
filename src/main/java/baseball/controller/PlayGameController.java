package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.model.Number;

import java.util.ArrayList;
import java.util.List;

public class PlayGameController {
    Number numbers = new Number();
    static InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ComputerController computerController = new ComputerController();

    private int strikeCount;
    private int ballCount;

    public void playGame(){
        boolean state = true;

        inputView.startMessage();
        while(state){
            setting();
            computerController.generateRandomNumbers(numbers);

            while(strikeCount != 3){
                gameStart(numbers);
                outputView.printResult(strikeCount, ballCount);
            }

            state = askRestartGame();
        }
    }

    private void gameStart(Number numbers){
//        setting();
//        computerController.generateRandomNumbers(numbers);
        guessNumbers(numbers);
    }

    private void setting() {
        strikeCount = 0;
        ballCount = 0;
    }

    private void guessNumbers(Number numbers) {
        inputPlayerNumbers(numbers);
        checkNumber(numbers);
    }

    private void inputPlayerNumbers(Number numbers){
        List<Integer> playerNumbers = new ArrayList<>();
        String number = inputView.inputNumber();

        for (int i = 0; i < number.length(); i++) {
            char n = number.charAt(i);
            if(isDigit(n)){
                if(duplicateCheck(n, playerNumbers)){
                    playerNumbers.add((int) n);
                }
            }
            else {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력 가능합니다.");
            }
        }
        numbers.setPlayerNumbers(playerNumbers);
    }

    private boolean duplicateCheck(int number, List<Integer> playersNumbers){
        if(!playersNumbers.contains(number)){
            return true;
        }
        else{
            throw new IllegalArgumentException("서로 다른 세 자리의 숫자만 입력 가능합니다.");
        }
    }

    private boolean isDigit(char checkChar) {
        return checkChar >= '1' && checkChar <= '9';
    }

    private void checkNumber(Number numbers) {
        List<Integer> players = numbers.getPlayerNumbers();
        List<Integer> computers = numbers.getComputerNumbers();

        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (players.get(i).equals(computers.get(j)) && i == j) {
                    strikeCount += 1;
                } else if (players.get(i).equals(computers.get(j)) && i != j) {
                    ballCount += 1;
                }
            }
        }
    }

    private static boolean askRestartGame(){
        String answer = inputView.inputRestart();
        return isRestartAnswer(answer);
    }

    private static boolean isRestartAnswer(String answer){
        if(answer.equals("1")){
            return true;
        }
        else if(answer.equals("2")){
            return false;
        }

        throw new IllegalArgumentException("1 혹은 2만 입력 가능합니다.");
    }
}
