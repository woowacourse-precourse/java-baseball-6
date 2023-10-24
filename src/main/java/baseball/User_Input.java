package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
//readLine();
public class User_Input {
    public static boolean Ask_Exit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String Confirm_exit = readLine();
        Error_Check.Exit_input_check(Confirm_exit);
        return Confirm_exit.equals("2");
    }
    public static int[] baseball_user_input() {
        int unconverted_number;
        int[] multi_number = {0,0,0};
        System.out.print("숫자를 입력해주세요 : ");
        String num = readLine();
        unconverted_number = Error_Check.num_input_check(num);
        multi_number[0]=unconverted_number/100;
        multi_number[1]=unconverted_number/10%10;
        multi_number[2]=unconverted_number%10;
        return multi_number;
    }
}
