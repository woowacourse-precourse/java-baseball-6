package baseball;
import java.util.Scanner;
import java.util.Random;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        for (int i = 0; i <3 ; i++) {
            int r = new Random().nextInt(8) + 1;//난수를 r에 저장
        }
        String number;
        System.out.println("Enter the number.");
        Scanner sc = new Scanner(System.in);
        number = sc.nextLine();



    }
}
