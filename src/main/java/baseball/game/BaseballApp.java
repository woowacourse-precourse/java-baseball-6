package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class BaseballApp {

    public Computer computer;

    public BaseballApp() {
        this.computer = new Computer();
    }

    //야구게임 앱을 키면 난수가 생성되고, 게임이 시작된다.
    public void run() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.genNumbers();

        startGame();
    }

    //게임을 진행한다.
    public void startGame() {

        while(true) {

            getInput();


        }

    }

    public String getInput() {

        //내용을 입력받는다.
        System.out.print("숫자를 입력해주세요 : ");
        if(checkInput(Console.readLine())) {

        }

        return "";
    }

    public boolean checkInput(String input) {

        if(input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자가 입력되어야 합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }

        return true;
    }

    public int parseInt(String input) {
        return 123;
    }

}
