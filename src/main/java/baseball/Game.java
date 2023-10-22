package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class Game {
    int strike;
    int ball;
    List<Integer> computerNum;
    int userNum;
    private boolean isPlaying = true;
    Computer computer = new Computer();
    User user = new User();

    public void gamePlay() {
        computer.setComputerNum();
        while (isPlaying) {
            user.setUserNum();
            isStrikeOrBall();
        }
    }

    void isStrikeOrBall() {
        computerNum = computer.getComputerNum();
        userNum = user.getUserNum();
        strike = 0;
        ball = 0;
        String userNumString = Integer.toString(userNum);
        for (int i = 0; i < computerNum.size(); i++) {
            int userDigit = Integer.parseInt(userNumString.charAt(i) + ""); // 문자를 정수로 변환
            if (computerNum.contains(userDigit)) {
                if (computerNum.get(i) == userDigit) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        call();
    }

    void call() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            isPlaying = false;
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            newGameOrExit();
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    void newGameOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            isPlaying = true;
            gamePlay();
        } else if (input.equals("2")) {
            isPlaying = false;
            System.out.println("게임을 종료합니다.");
        } else {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}
// 테스트 만들기 -> ApplicationTest이거는 그대로 두면 되겠지?
// 요구사항 확인하기, 리팩토링하기
// ./gradlew clean test 확인하기
// 회고 정리하기 및 학습하기
// 학습 내용도 커밋해야하나?
