package baseball;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Human human = new Human();
        Referee referee = new Referee();

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.setNumber(computer.setInput());

        while (true) {
            human.setNumber(human.setInput());
            referee.compareNumbers(human, computer);
            referee.printScore();

            if(referee.checkComplete()) {
                System.out.println(("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."));
                if(Integer.parseInt(Console.readLine()) != 1)
                    break;
                System.out.println("숫자 야구 게임을 시작합니다.");
                computer.setNumber(computer.setInput());
            }
        }
    }
}
