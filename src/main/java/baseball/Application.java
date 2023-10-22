package baseball;

import baseball.controller.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String s;
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame baseballGame = new BaseballGameImpl(new GenerateTargetNumImpl(),new ValidUserNumImpl(),new JudgeCountNumImpl());
        while(true) {

            baseballGame.playBaseballGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            s=Console.readLine();

            if(s.equals("1")){
                continue;
            }
            else if(s.equals("2")){
                break;
            }
            else{
                throw new IllegalArgumentException();
            }
        }
    }
}
