package baseball.view;

public class BaseballPrint {
    public void printStartMent(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printEndMent(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRetryMent(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printResult(int strike, int ball){
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public void requestInput(){
        System.out.print("숫자를 입력해주세요 :");
    }

}
