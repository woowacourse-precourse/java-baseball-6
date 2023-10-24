package baseball.service;

import baseball.view.InputView;

public class ValidationInput {
    InputView inputView = new InputView();
    public String askGameRestart(){
        String choice = inputView.askPlayerChoice();
        isValidChoice(choice);
        return choice;
    }

    //사용자 선택 검증 함수
    private void isValidChoice(String choice){
        if(!(choice.equals("1") || choice.equals("2"))){
            throw new IllegalArgumentException("사용자의 입력이 1또는 2가 아닙니다. 게임을 종료합니다.");
        }
    }
}
