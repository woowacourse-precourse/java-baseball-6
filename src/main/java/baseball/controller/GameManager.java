package baseball.controller;

import baseball.model.UserNumberDto;
import baseball.view.UserView;
import java.util.List;

public class GameManager {
    //인스턴스
    private Computer computer;
    private User user;
    private UserView userView;

    //변수명
    private List<Integer> computerRandomNumbers;

    private UserNumberDto userNumberDto;

    //생성자
    public GameManager(){
        computer = new Computer();
        user = new User();
        userView = new UserView();
    };

    public void startGame(){
        computerRandomNumbers = computer.getRandomComputerNumber(); //랜덤한 3개 컴퓨터 숫자 생성
        userView.printGameStartMessage(); //게임시작 메시지 출력
        userView.printNumberInputPrompt(); //user input 프롬포트 메시지 출력
        userNumberDto = user.readUserNumberInput(); //user input 시행
    }
}
