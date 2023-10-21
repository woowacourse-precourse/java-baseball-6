package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart= Console.readLine();
        if(restart.equals("1")){
            return true;
        }
        return false;
    }
}
