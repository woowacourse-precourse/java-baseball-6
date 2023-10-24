package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application.game();
    }

    public static void game(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        System.out.print("테스트용 입력 : ");

        String inputNum = readLine();
        try {
            int changeNum = Integer.parseInt(inputNum);
            System.out.println(changeNum);
        } catch (NumberFormatException ex5) {
            ex5.printStackTrace();
        }

        System.out.print("숫자를 입력해주세요 : ");

        String str1 = readLine();
        String str2 = readLine();
        String str3 = readLine();

        try {
            int number1 = Integer.parseInt(str1);
            //System.out.println(number1);
            try {
                int number2 = Integer.parseInt(str2);
                //System.out.println(number2);
                try {
                    int number3 = Integer.parseInt(str3);
                    //System.out.println(number3);
                    if (number1 < 1 || number1 > 9 ||
                            number2 < 1 || number2 > 9 ||
                            number3 < 1 || number3 > 9) {
                        throw new IllegalArgumentException();
                    }
                    List<Integer> number = new ArrayList<>();
                    number.add(number1);
                    number.add(number2);
                    number.add(number3);
                    //System.out.println(number);
                    boolean result = Arrays.equals(computer.toArray(), number.toArray());
                    //System.out.println(result);

                    if (result == true){
                        System.out.println("3스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String str4 = readLine();
                        try{
                            int choice = Integer.parseInt(str4);
                            //System.out.println();
                            if (choice < 1 || choice > 2) {
                                throw new IllegalArgumentException();
                            }
                            if (choice == 1){
                                Application.game();
                            }
                        } catch (NumberFormatException ex4) {
                            ex4.printStackTrace();
                        }

                    } else {
                        int strike = 0;
                        int ball = 0;
                        for (int i = 0; i < computer.size(); i ++) {
                            if (computer.get(i) == number.get(i)) {
                                strike += 1;
                            }
                        }
                        for (int j = 0; j < computer.size(); j++) {
                            for (int k = 0; k < number.size(); k++){
                                if (computer.get(j) == number.get(k)) {
                                    ball += 1;
                                }
                            }
                        }
                        System.out.println(strike + "스트라이크 " + (ball-strike) + "볼");
                    }




                } catch (NumberFormatException ex1){
                    ex1.printStackTrace();
                }
            } catch (NumberFormatException ex2){
                ex2.printStackTrace();
            }
        } catch (NumberFormatException ex3){
            ex3.printStackTrace();
        }
    }

}
