package baseball.service;

import baseball.domain.Score;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PrintService {

    public void printBeforeStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(int strike, int ball){
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
            return;

        } if (strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (ball > 0) {
            System.out.printf("%d볼\n", ball);
        }

    }
    public void showResult(Score score) {
        printGameResult(score.getStrike(), score.getBall());
    }

    public boolean printAfterFinish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        //유효한 숫자인지 검증하는 로직 필요
        ValidCheckService.validExitNumber(input);
        if (input.equals("2")) {
            return true;
        }
        return false;
    }

}
