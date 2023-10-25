package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        Human human = new Human();
        Computer computer;
        boolean systemFlag = true;

        while (systemFlag) {
            computer = new Computer();
            System.out.println("숫자 야구 게임을 시작합니다.");
            boolean gameFlag = true;

//            System.out.println(computer);
            while (gameFlag) {

                human.setNumber();
                if (computer.compareNumber(human.getNumber()) == BaseballResult.S3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameFlag = false;
                }
//                System.out.println(human);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int menu = Integer.parseInt(Console.readLine());
            if (menu == 2) {
                systemFlag = false;
            }
//            computer.setNumber();

        }

    }
}
