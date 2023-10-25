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

    private boolean isCorrectNumber;
    private boolean isPauseGame;

    //생성자
    public GameManager(){
        computer = new Computer();
        user = new User();
        userView = new UserView();
        judgement = new Judgement();

        isCorrectNumber = false;
        isPauseGame = false;
    }

    public void startGame(){
        userView.printGameStartMessage(); //게임시작 메시지 출력
        while(!isPauseGame){
            computerNumberDto = computer.getRandomComputerNumber(); //랜덤한 3개 컴퓨터 숫자 생성
            isCorrectNumber = false;

            while(!isCorrectNumber){ //정답을 맞출 때까지 입력 반복
                userView.printNumberInputPrompt(); //user input 프롬포트 메시지 출력
                userNumberDto = user.readUserNumberInput(); //user input 시행
                gameResultDto = judgement.compareNumbers(computerNumberDto,userNumberDto); //컴퓨터 숫자와 사용자 입력 숫자 비교
                userView.printResultOfJudgement(gameResultDto); //게임 결과 값 출력
                isCorrectNumber = gameResultDto.getIsCorrectNumber(); //정답여부 확인
            }

            userView.printResumeInputPrompt(); //게임 재실행 여부 프롬포트 메시지 출력
            isPauseGame = user.readUserPauseOrResumeInput(); //게임 재실행 여부 입력
        }
    }
}
