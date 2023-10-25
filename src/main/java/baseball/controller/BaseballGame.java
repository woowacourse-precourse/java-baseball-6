package baseball.controller;

import baseball.model.GameState;
import baseball.model.Computer;
import baseball.model.User;
import baseball.util.ValidationCheck;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    // member variables
    private final Computer computer; // computer instance
    private final User user; // user instance
    private final Score score; // score instance
    private final ValidationCheck validationCheck; // validation instance
    private GameState state; // state enum

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.score = new Score();
        this.validationCheck = new ValidationCheck();
        this.state = GameState.RUNNING;
    }

    public void run(){
        // 초기 셋팅
        boolean isFinish;
        // Game start
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(state != GameState.EXIT){
            System.out.print("숫자를 입력해주세요 : ");
            String userNum = Console.readLine();
            // validation check about user number
            if(!validationCheck.validateUserNumber(userNum)){
                throw new IllegalArgumentException("잘못된 입력입니다."); // raise error
            }
            user.generateNumbers(userNum); // setting user numbers

            // checking score
            isFinish = score.checkScore(this.computer, this.user);
            if(isFinish){
                replay();
            }
        }
    }

    private void replay(){
        // local variable
        int cmdInt;
        // print and input
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cmdStr = Console.readLine();
        // validation check about user command
        if(!validationCheck.validateUserCommand(cmdStr)){
            throw new IllegalArgumentException("잘못된 입력입니다."); // raise error
        }
        cmdInt = Integer.parseInt(cmdStr);
        if(cmdInt == 1){
            computer.generateNumbers(); // reset computer numbers
        }else if(cmdInt == 2){
            state = GameState.EXIT;
        }
    }
}
