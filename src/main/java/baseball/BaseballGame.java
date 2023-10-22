package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    String inputNumbers;
    int strike = 0;
    int ball = 0;

    private Computer computer;

    public void start(){
        computer = new Computer();
        computer.createNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            inputNumbers();
        }
    }

    public void inputNumbers(){
        // check point
        // null인지, size가 3인지, 숫자인지, 서로다른 숫자인지
        System.out.print("숫자를 입력해주세요 : ");
        String temp = readLine();
        inputNumbers = temp;
    }

}
