package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Game {
    private String computerNum;
    private String userNum;
    Map<String, Integer> result;
    Calculator calculator = new Calculator();
    ResultCalculator resultCalculator = new ResultCalculator();
    Computer computer = new Computer();
    public void start() {
        boolean isContinue = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isContinue) {
            setGame();
            isContinue = playGame();
        }
        System.out.println("게임을 종료합니다.");
    }
    public void setGame() {
        computerNum = getComputerNum();
    }

    public boolean playGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userNum = Console.readLine();
            calculator.numberAnalysis(computerNum, userNum);
            if (gameWin() == true) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String inputRestart = Console.readLine();
                return restartGame(inputRestart);
            }
        }
    }

    public boolean restartGame(String inputRestart) {
        if (inputRestart.equals("1")) {
            setGame();
            return false;
        }
        if (inputRestart.equals("2")) {
            return true;
        }
        return true;
    }

    public boolean gameWin() {
        return resultCalculator.resultAnalysis(calculator.getResult());
    }

    public String getComputerNum() {
       return getComputer().generate();
    }
    public Computer getComputer() {
        return computer;
    }
}
