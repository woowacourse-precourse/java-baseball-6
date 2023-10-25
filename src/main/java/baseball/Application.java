package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int flag = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            while (flag == 1) {
                //컴퓨터 객체 생성
                Computer enemy = new Computer(false);
                enemy.generateNum();
                //유저 객체 생성
                User user = new User();

                while (!enemy.isDone()) {
                    System.out.print("숫자를 입력해주세요 : ");
                    user.InputAnswer();
                    System.out.println(enemy.checkBaseball(user.userAnswer));
                    if (enemy.checkBaseball(user.userAnswer).equals("3스트라이크")) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        enemy.setDone(true);
                    }
                }
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                flag = Integer.parseInt(Console.readLine());
            }
            System.out.println("게임 종료");
        } catch (Exception e) {
            System.out.println("게임 종료");
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

    }
}
