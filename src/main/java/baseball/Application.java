package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        BaseBall baseBall = new BaseBall();

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                if (baseBall.evaluate(Console.readLine())) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String inputExitStatus = Console.readLine();
                    if (!inputExitStatus.equals("1") && !inputExitStatus.equals("2")) {
                        throw new IllegalArgumentException("잘못된 입력값입니다.");
                    }
                    if (inputExitStatus.equals("2")) {
                        System.out.println("게임 종료");
                        break;
                    }
                    baseBall.reset();
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
