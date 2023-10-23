package Utills;

public class Messages {
    public static void gameMessage(int ball, int strike){
        noneBallAndStrikeMessage(ball, strike);
        ballMessage(ball);
        strikeMessage(strike);
        System.out.println();
    }
    public static void gameReStartMessage(){
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하러면 1, 종료하려면 2를 입력하세요.");
    }
    public static void gameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void inputRequestMessage(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    private static void noneBallAndStrikeMessage(int ball, int strike){
        if(ball == 0 && strike ==0){
            System.out.println("낫싱");
        }
    }

    private static void ballMessage(int ball){
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
    }
    private static void strikeMessage(int strike){
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
    }
}
