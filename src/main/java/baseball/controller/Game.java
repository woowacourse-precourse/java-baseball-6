package baseball.controller;

import baseball.util.Compare;
import baseball.util.Exception;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    private Computer computer;
    private User user;

    //생성자
    private Game(){
        computer = Computer.create(); //computer 객체 생성
        user = User.create(); //user 객체 생성
        OutputView.start(); //게임 시작
    }

    //Game 생성
    public static Game create(){
        return new Game();
    }

    //game 시작
    public void start(){

        createComputerNums(); //computer 난수 생성

        //3스트라이크가 아닐 시 계속 실행
        do{
            userInput(); //숫자 입력받기
            compareNum(); //입력 받은 수와 컴퓨터 수 비교
            printResult(); //결과 출력
        } while(Compare.isNotThreeStrike());

    }

    //computer 난수 생성
    public void createComputerNums(){
        computer.createRandomNums();
    }

    //user 수 입력 받기
    public void userInput(){
        String input = InputView.input();
        Exception.validate(input); //입력 값 검증
        user.convertInput(input); //입력 값 int 형으로 변환
    }

    //user 수와 computer 수 비교
    public void compareNum(){
        Compare.compareNum(computer.getComputerNum(), user.getUserNum());
    }

    //결과 출력
    public void printResult(){
        OutputView.printResult(Compare.getStrike(), Compare.getBall());
    }

    //게임 종료 후 게임 재시작 여부 입력받기
    public static boolean isRestart() {
        String restartInput = InputView.restart();

        if (restartInput.equals("1")){
            return true;
        }

        if (restartInput.equals("2")){
            OutputView.end();
            return false;
        }

        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }

}
