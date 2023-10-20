package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        Computer com = new Computer();
        Rules rules = new Rules();

        System.out.println("숫자 야구 게임을 시작합니다.");
        com.getNumbers();

        while (true) {
            // 사용자 입력
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            user.getIntArray(input);
            // 스트라이크, 볼 개수 구하기
            rules.countBallAndStrikes(com.getList(), user.getList());
            // 결과 출력
            if (!rules.isThreeStrikes()) {
                rules.printBallAndStrikes();
                user.clearList();
                continue;
            }
            // 게임 재시작 여부 결정
            System.out.println("3스트라이크");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            input = Console.readLine();
            if (input.equals("1")) {
                com.getClear();
                com.getNumbers();
            }
            if (input.equals("2")) {
                break;
            }
        }
        System.out.println("숫자 야구 게임을 종료합니다.");
        Console.close();
    }
}
