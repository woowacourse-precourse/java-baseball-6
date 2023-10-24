package baseball.utils;

import baseball.game.Score;

public class PrintUtils {
    public void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printQuestion(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printClear(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartQuestion(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printScore(Score score){
        String answer = "";

        if (score.getBall()>0){
            answer += score.getBall() + "볼 ";
        }

        if (score.getStrike()>0){
            answer += score.getStrike() + "스트라이크 ";
        }

        if (answer.isEmpty()){
            answer = "낫싱";
        }

        System.out.println(answer);
    }


}
