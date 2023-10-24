package baseball.view;

public class OutputView {
    public void printInitialMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputInfoMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResultMessage(int strike, int ball){
        if(strike==0 && ball==0){
            System.out.println("낫싱");
        } else if (strike==0) {
            System.out.println(ball+"볼");

        } else if (ball ==0) {
            System.out.println(strike+"스트라이크");
        }
        else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }

    }

    public void printClosingMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printChoiceInfoMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
