package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame bf = new BaseballFunction();
        Scanner scanner = new Scanner(System.in);
        int game_exe = 1;

        while(true) {
            System.out.print("입력: ");
            String input_number = scanner.next();
            if (input_number.length() < 3 || input_number.length() > 3) {
                throw new IllegalArgumentException(input_number.toString());
            }

            bf.compare_number(Integer.parseInt(input_number));

            if(bf.print_result()) {
                System.out.print("계속하시겠습니까? ");
                game_exe = scanner.nextInt();

                if(bf.game_exe(game_exe)) {
                    break;
                }
            }
        }
    }
}
