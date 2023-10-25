package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        // 객체 생성
        baseballGame b1 = new baseballGame();

        exit_for:
        while (true) {
            // 컴퓨터 숫자 생성
            b1.computerNumberArrList();
            // System.out.println(b1.computerNumber);
            while (true) {
                System.out.printf("숫자를 입력해주세요 : ");
                // 사용자 숫자 입력
                try {
                    String strUserInput = Console.readLine();
                    b1.userNumberArrList(strUserInput);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException();
                }

                // 볼, 스트라이크 개수 구하기
                b1.getStrikeAndBall();

                // 입력한 수에 대한 결과를 볼, 스트라이크로 출력
                b1.printStrikeAndBall();

                // 3스트라이크가 되었을 때 추가 입력
                if (b1.s == 3) {
                    String continueOrstop = Console.readLine();
                    try {
                        b1.restartOrQuit(continueOrstop);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException();
                    }
                    if (Integer.parseInt(b1.restartOrQuit(continueOrstop)) == 1) {
                        break;
                    } else if (Integer.parseInt(b1.restartOrQuit(continueOrstop)) == 2) {
                        break exit_for;
                    }
                }
            }
        }
    }
}


