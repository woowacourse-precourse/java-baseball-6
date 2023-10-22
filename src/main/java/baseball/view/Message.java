package baseball.view;

public class Message {

    public static void InputNessage(){
//        System.out.print("숫자를 입력해주세요. : ");
        System.out.print("input number. : ");
    }

    public void scoreMessage(int ball, int strike){
        if(ball == 0 && strike ==0){
            System.out.println("notttig");
        }
        if(ball != 0 && strike ==0){
            System.out.println(ball + "ball");
        }
        if(ball == 0 && strike !=0){
            System.out.println(strike + "strike");
        }
        if(ball == 0 && strike ==0){
            System.out.println(ball + "ball" + strike + "strike");
        }
    }

    public void gameoverMessage(){
        System.out.println("you win!!");
    }
}
