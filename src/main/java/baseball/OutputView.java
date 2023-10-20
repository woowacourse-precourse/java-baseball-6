package baseball;

public class OutputView {
    public void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printResult(int strike, int ball){
        if (strike==3){
            System.out.println("3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (strike==0 && ball>0){
            System.out.println(ball+"볼");
            return;
        }
        if (strike>0 && ball==0){
            System.out.println(strike+"스트라이크");
            return;
        }
        if (strike>0 && ball>0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
            return;
        }
        System.out.println("낫싱");
    }
}
