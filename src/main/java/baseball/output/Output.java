package baseball.output;

public class Output {
    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void collect(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void outResult(String result){
        System.out.println(result);
    }

    public void getInput(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public String makeString(int strike, int ball){
        if(strike == 0 && ball == 0) return "낫싱";
        else if(strike != 0 && ball == 0)return strike + "스트라이크";
        else if(strike == 0)return ball + "볼";
        return ball + "볼 " + strike + "스트라이크";
    }
}
