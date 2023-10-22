package baseball.view;

public class Message {

    public static void InputNessage(){
        System.out.print("숫자를 입력해주세요 : ");
//        System.out.print("inputnum : ");
    }

    public void scoreMessage(int ball, int strike){
        if(ball == 0 && strike ==0){
            System.out.println("낫싱");
//            System.out.println("notting");
        }
        if(ball != 0 && strike ==0){
            System.out.println(ball + "볼");
//            System.out.println(ball + "ball");
        }
        if(ball == 0 && strike !=0){
            System.out.println(strike + "스트라이크");
//            System.out.println(strike + "strike");
        }
        if(ball != 0 && strike !=0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
//            System.out.println(ball + "ball" + strike + "strike");

        }
    }

    public void gameWinMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//        System.out.println("you win! game end");

    }
    public static void reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//        System.out.println("moregame 1, endgame 2 gogo.");
    }
}
