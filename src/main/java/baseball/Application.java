package baseball;

import baseball.player.Defender;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static boolean  playState; // true 일시 게임 진행 false 일시 게임 종료
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        playState = true;
        while(playState){



            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int restartNum = Integer.parseInt(readLine());
            switch (restartNum){
                case 1:
                    playState = true;
                    break;
                case 2:
                    playState = false;
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 입력입니다");

            }



        }


    }
}
