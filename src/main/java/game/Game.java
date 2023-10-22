package game;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            play();
            break;
        }

    }

    private void play(){
        String computer[] = getComputerPlay();

        String player[] = getUserPlay();

        judgePlay(computer, player);
    }

    private String[] getComputerPlay(){
        //서로 다른 숫자 입력할 수 잇게끔 해야함
        String computerPlay[] = new String[3];

        String firstBall = String.valueOf(Randoms.pickNumberInRange(1, 9));
        computerPlay[0] = firstBall;
        String secondBall = String.valueOf(Randoms.pickNumberInRange(1, 9));
        computerPlay[1] = secondBall;
        String thirdBall = String.valueOf(Randoms.pickNumberInRange(1, 9));
        computerPlay[2] = thirdBall;

        return computerPlay;
    }

    private String[] getUserPlay(){
        System.out.print("숫자를 입력해주세요 : ");

        String userPlay[] = Console.readLine().split("");

        return userPlay;
    }

    private void judgePlay(String[] computerPlay, String[] userPlay){
        System.out.println("x볼 x스트라이크");
    }
}
