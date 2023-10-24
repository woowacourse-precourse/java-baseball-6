package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void startMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String inputNumber(){
        System.out.print("숫자를 입력해주세요 :");
        String inputNumbers = Console.readLine();
        if(inputNumbers.length() != 3){
            throw new IllegalArgumentException("숫자 세 자리를 입력해주세요.");
        }
        else{
            return inputNumbers;
        }
    }

    public String inputRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
