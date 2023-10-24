package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {



    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String enterUserAnswer(){
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        if(restart.equals("1")){
            return true;
        }
        return false;
    }
}
