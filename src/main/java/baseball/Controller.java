package baseball;

import baseball.Service.PlayballGame;
import baseball.View.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    PlayballGame playballService = new PlayballGame();

    public void run(){
        //게임 세팅
        setGame();
        //게임 시작
        startGame();
        //게임 종료
        endGame();
        //재시작 묻기
        askRestart();
    }

    //게임 세팅
    public void setGame(){

    }

    //게임 시작
    public void startGame(){
        System.out.print("숫자를 입력해주세요 : ");


    }

    //게임 종료
    public void endGame(){
        System.out.print("게임을 종료합니다.");
    }

    //재시작 묻기
    public void askRestart(){
        //사용자 입력받기
        UserInput.askUserInput();
        if(checkRestartNumber().equals('1')){
            run();
        }
    }
    private String checkRestartNumber() throws IllegalArgumentException {
        UserInput.askUserInput();
        String responseRestart = Console.readLine();

        if (!responseRestart.equals('1') |!responseRestart.equals('2')) {
            throw new IllegalArgumentException();
        }
        return responseRestart;
    }
}
