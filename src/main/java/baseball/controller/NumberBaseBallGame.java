package baseball.controller;

import baseball.Computer;
import baseball.UserInput;

import java.util.List;

public class NumberBaseBallGame {

    Computer computer = new Computer();
    UserInput user = new UserInput();
    private int ball = 0;
    private int strike = 0;

    public void startGame(){
        //정답 생성
        List<Integer> answer = makeGame();

        //user가 정답을 맞출때까지 user 입력, 볼,스트라이크 출력 반복
        while(strike != 3){
            List<Integer> userInput = user.getUserInput();

            //사용자가 입력한 숫자와 컴퓨터가 저장한 숫자를 비교하여 볼과 스트라이크를 구한다.
            ball = getBall(answer, userInput);
            strike = getStrike(answer, userInput);

            //볼과 스트라이크 값을 출력한다.
            printBallAndStrike(ball, strike);
        }

        // TODO : 스트라이크가 3이 나오면 user에게 재시작, 종료 입력 받기



    }

    public List<Integer> makeGame(){
        return computer.makeNewNumber();
    }

    private int getStrike(List<Integer> answer, List<Integer> userInput) {
        return computer.compareUserInputAndAnswer(userInput, answer).getStrike();
    }

    private int getBall(List<Integer> answer, List<Integer> userInput) {
        return computer.compareUserInputAndAnswer(userInput, answer).getBall();
    }

    private static void printBallAndStrike(int ball, int strike) {
        if(ball != 0){
            System.out.print(ball + "볼 ");
        }
        if(strike != 0){
            System.out.print(strike + "스트라이크");
        }
        if(ball==0 && strike ==0){
            System.out.print("낫싱");
        }
        System.out.println();
    }

}
