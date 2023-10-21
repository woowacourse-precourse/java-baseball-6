package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {

    private static void newGame() {
        Computer computer = initAnswer();
        List<Integer> result;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            Player player = new Player(
                    List.of(input.charAt(0) - '0',
                            input.charAt(1) - '0',
                            input.charAt(2) - '0'));

            result = player.compareToAnswer(computer);
            int ball = result.get(0);
            int strike = result.get(1);

            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else {
                String ballInfo = ball != 0 ? (ball + "볼") : "";
                String strikeInfo = strike != 0 ? (strike + "스트라이크") : "";
                String info = (ball != 0 && strike != 0) ? (ballInfo + " " + strikeInfo) : (ballInfo + strikeInfo);
                System.out.println(info);
            }

        } while (result.get(1) != 3);
    }

    //TODO: private 메서드에 static을 붙이는 게 적절한지 확인
    private static Boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int newOrQuit = Integer.parseInt(Console.readLine());
        if (newOrQuit==1) return true;
        else if(newOrQuit==2) return false;
        else {
            System.out.println("잘못된 입력입니다.");
            throw new IllegalArgumentException("재시작/종료 숫자 미일치");
        }
    }

    private static Computer initAnswer() {
        return new Computer();
    }
}