package baseball.controller;


import static baseball.controller.Computer.computer;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private String computerNum;
    private String userNum;
    public Game() {
        Computer computer = Computer.getInstance();
        Calculator calculator = new Calculator();
    }

   public void start() {
       System.out.println("숫자 야구 게임을 시작합니다.");
       computerNum = getComputerNum();
       System.out.print("숫자를 입력해주세요 : ");
       userNum = Console.readLine();

   }

   public String getComputerNum() {
       return getComputer().generate();
   }
   public Computer getComputer() {
        return computer;
   }

}
