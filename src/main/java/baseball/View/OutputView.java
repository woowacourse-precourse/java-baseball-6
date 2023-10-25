package baseball.View;

public class OutputView {
    public void startMsg(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void resultMsg(int strick, int ball){
        if(strick == 3) System.out.println("3스트라이크");
        else if (strick != 0 && ball != 0) System.out.println(ball + "볼 " + strick + "스트라이크");
        else if (strick != 0) System.out.println(strick + "스트라이크");
        else if (ball != 0) System.out.println(ball + "볼");
        else System.out.println("낫싱");
    }

    public void endMsg(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}