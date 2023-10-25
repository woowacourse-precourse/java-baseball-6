package baseball;

import java.util.ArrayList;

public class Game {

    private Computer computer;
    private UserInput userInput;
    private ArrayList<Integer> userGuess;
    private int ballCount;
    private int strikeCount;

    public Game(){
        computer = new Computer();
        userInput = new UserInput();
        strikeCount = 0;
        ballCount = 0;
        userGuess = new ArrayList<>();

    }

    public void saveUserInput() {
        userGuess.clear();
        int input = userInput.getUserGuess();

        String inputString = String.valueOf(input);
        if (inputString.length() != 3) {
            throw new IllegalArgumentException();
        }

        while (input > 0) {
            userGuess.add(input % 10);
            input /= 10;
        }
    }


    public void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            saveUserInput();
            strikeCount = 0;
            ballCount = 0;

            for (int i = 0; i< 3 ; i++){
                if (userGuess.get(i).equals(computer.getComputerNums().get(i))) {
                    strikeCount++;
                } else if (computer.getComputerNums().contains(userGuess.get(i))) {
                    ballCount++;
                }
            }
            OutputFormatter.formatOutput(strikeCount,ballCount);

            if (strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                int choice = userInput.getRestartOrExit();
                if (choice == 1) {
                    computer = new Computer();
                } else if (choice == 2) {
                    System.out.println("게임 종료");
                    break;
                }
            }






        }

    }








}