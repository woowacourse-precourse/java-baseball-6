package baseball;

public class OutputWriter {
    public void printGameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResultOfInput(int ball, int strike){
        if(isZero(ball) && isZero(strike)) System.out.println("낫싱");
        else if(!isZero(ball) &&  isZero(strike)) System.out.println(ball + "볼");
        else if( isZero(ball) && !isZero(strike)) System.out.println(strike + "스트라이크");
        else if(!isZero(ball) && !isZero(strike)) System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void printGameFinishMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public boolean isZero(int num){
        return num == 0;
    }
}
