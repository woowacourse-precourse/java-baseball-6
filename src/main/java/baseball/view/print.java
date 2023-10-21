package baseball.view;

public class print {

    public static void printInit(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printWin(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printResult(int ball, int strike){
        // 0볼 0스트라이크
        if(ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        // 0볼
        else if(ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        // 0스트라이크
        else if(ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        // 낫싱
        else {
            System.out.println("낫싱");
        }
    }
}
