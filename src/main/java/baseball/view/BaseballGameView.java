package baseball.view;

public class BaseballGameView {

    public void startGamePrint(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void readNumPrint(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void nothingResultPrint(){
        System.out.print("낫싱");
    }

    public void ballResultPrint(int ball){
        System.out.print(ball + "볼 ");
    }

    public void strikeResultPrint(int strike){
        System.out.print(strike + "스트라이크 ");
    }

    public void endGamePrint(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
