package baseball.view;

public class Info {

    public static void printInfo(int strikes, int balls) {
        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else{
            System.out.println();
        }

        if (strikes == 3) {
            Message.gameEnd();
        }
    }
}
