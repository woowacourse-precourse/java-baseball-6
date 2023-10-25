package baseball.view;

public class OutputView {
    public static void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResultMessage(int balls, int strikes){
        if(balls == 0 && strikes == 0) {
            System.out.print("낫싱");
        } else {
            if(strikes != 0) {
                System.out.print(strikes + "스트라이크 ");
            }
            if(balls != 0) {
                System.out.print(balls + "볼 ");
            }
        }
        System.out.println();
    }
    public static void printGameSetMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
