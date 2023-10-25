package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    ComputerNumber computer = new ComputerNumber(3);
    UserNumber user = new UserNumber(3);
    ContinueNumber checkContinue = new ContinueNumber(1);
    String output;
    int ball;
    int strike;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        //4. 게임 시작, 종료를 위한 숫자 입력 받기
        do {
            computer.generateRandomNumber();
            guessNumber();
        } while (checkContinue.returnFlag());
    }

    public void guessNumber() {
        do {
            inputUntilCorrect();
        } while (!compareNumber(computer.getNumbers(), user.getNumbers()));
        checkRetry();
    }

    //2. 사용자 값 입력 받기(같을 때까지)
    public void inputUntilCorrect() {
        System.out.print("숫자를 입력해주세요 : ");
        user.setInput(Console.readLine());
        user.setUserNumberList();
    }

    public boolean compareNumber(ArrayList<Integer> c, ArrayList<Integer> u) {
        //3. 볼의 개수, 스트라이크 개수 출력 하기
        boolean flag = false;
        output = "";
        ball = 0;
        strike = 0;
        for (int i = 0; i < 3; i++) {
            if (c.contains(u.get(i))) {
                if (c.get(i).equals(u.get(i)))
                    strike++;
                else
                    ball++;
            }
        }
        if (ball == 0 && strike == 0)
            output += "낫싱";
        else {
            if (ball >= 1)
                output += ball + "볼";
            if (ball >= 1 && strike >= 1)
                output += " ";
            if (strike >= 1)
                output += strike + "스트라이크";

            if (strike == 3) {
                output += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
                flag = true;
            }
        }
        System.out.println(output);
        return flag;
    }

    public void checkRetry(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        checkContinue.setInput(Console.readLine());
        checkContinue.checkInput();
    }
}
