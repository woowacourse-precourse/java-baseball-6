package baseball.controller;

import baseball.model.ComputerNumberDto;
import baseball.model.GameResultDto;
import baseball.model.UserNumberDto;
import baseball.view.UserView;

public class GameManager {
    //인스턴스
    private Computer computer;
    private User user;
    private UserView userView;
    private Judgement judgement;

    //변수명
    private ComputerNumberDto computerNumberDto;
    private UserNumberDto userNumberDto;
    private GameResultDto gameResultDto;

    //생성자
    public GameManager(){
        computer = new Computer();
        user = new User();
        userView = new UserView();
        judgement = new Judgement();
    }

    public void startGame(){
        computerNumberDto = computer.getRandomComputerNumber(); //랜덤한 3개 컴퓨터 숫자 생성
        userView.printGameStartMessage(); //게임시작 메시지 출력
        userView.printNumberInputPrompt(); //user input 프롬포트 메시지 출력
        userNumberDto = user.readUserNumberInput(); //user input 시행
        gameResultDto = judgement.compareNumbers(computerNumberDto,userNumberDto); //컴퓨터 숫자와 사용자 입력 숫자 비교
        userView.printResultOfJudgement(gameResultDto); //게임 결과 값 출력
    }
}
