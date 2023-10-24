package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    void run(){
        while(true){
            play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if(input.equals("1")) continue;
            else if(input.equals("2")) break;
        }
    }

    void play(){
        Computer computer = new Computer();
        Player player = new Player();

        List<Integer> answer = computer.makeAnswer();
        List<Integer> user = player.input();
        while(true){
            BallCount ballCount = computer.calBallCount(answer, user);
            int strike = ballCount.getStrike();
            int ball = ballCount.getBall();

            if(strike==3) {
                System.out.println(String.format("%d스트라이크",strike));
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            else if (strike == 0 && ball == 0) System.out.println("낫싱");
            else System.out.println(String.format("%d볼 %d스트라이크", ball, strike));

            user = player.input();
        }
    }

}
