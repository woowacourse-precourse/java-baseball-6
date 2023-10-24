package Game;

public class PrintManager {

    public void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printScanRequire(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(int ball, int strike){
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
            return;
        }
        String ballStr = "";
        String strikeStr = "";
        if(ball != 0){
            ballStr = ball + "볼 ";
        }
        if(strike != 0){
            strikeStr = strike + "스트라이크 ";
        }
        System.out.println(ballStr + strikeStr);
    }

    public void printWin(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
