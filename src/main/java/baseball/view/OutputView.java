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
}
