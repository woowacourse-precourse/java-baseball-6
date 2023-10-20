package baseball;

public class PrintMessage {

    public void gameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputNumberMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void gameResult(int ball, int strike){
        if(strike == 3){
            System.out.println("3스트라이크");
            threeStrikeMessage();
            return;
        }

        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
            return;
        }

        if(ball >= 1 && strike >= 1){
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
            return;
        }

        if(ball >= 1 && strike == 0){
            System.out.println(String.format("%d볼", ball));
            return;
        }

        if(ball >= 0 && strike >= 1){
            System.out.println(String.format("%d스트라이크", strike));
            return;
        }
    }

    public void threeStrikeMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void gameCommand(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
