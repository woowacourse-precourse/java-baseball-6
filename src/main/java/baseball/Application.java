package baseball;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        Player computer = new Player(new Computer());
        Player human = new Player();
        Referee referee = new Referee();

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.addNumber();

        while (true) {
            human.addNumber();
            referee.compareNumber(human, computer);
            referee.printScore();

            if(referee.checkComplete()) {
                System.out.println(("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."));
                if(Integer.parseInt(Console.readLine()) != 1)
                    break;
                System.out.println("숫자 야구 게임을 시작합니다.");
                computer.addNumber();
            }
        }
    }
}
