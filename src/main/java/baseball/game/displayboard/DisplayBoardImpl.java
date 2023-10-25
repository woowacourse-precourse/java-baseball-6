package baseball.game.displayboard;

import baseball.game.Score;

public class DisplayBoardImpl implements DisplayBoard {
    @Override
    public void displayGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void displayRequestNum() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void displayScore(Score score) {
        //점수 확인하여 상황에 맞게 출력
        if (score.getBallCount() > 0) {
            System.out.print(score.getBallCount());
            System.out.print("볼");
            if(score.getStrikeCount() > 0){
                System.out.print(" ");
            }
        }
        if (score.getStrikeCount() > 0) {
            System.out.print(score.getStrikeCount());
            System.out.print("스트라이크");
        }
        if (score.isNothingCount() == true) {
            System.out.print("낫싱");
        }

        System.out.println();

        if (score.isHomerunCount() == true) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    @Override
    public void displayQuestionRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
