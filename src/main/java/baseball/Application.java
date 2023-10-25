package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Application.game();
    }
    public static void game(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.print("숫자를 입력해주세요 : ");

        String inputNum = readLine();

        try {
            int changeNum = Integer.parseInt(inputNum);
            if (changeNum < 111 || changeNum > 999){
                throw new IllegalArgumentException();
            }

            ArrayList<Integer> splitNum = new ArrayList<>();

            while (changeNum > 0) {
                splitNum.add(changeNum%10);
                changeNum /= 10;
            }

            Collections.reverse(splitNum);

            boolean result = Arrays.equals(computer.toArray(), splitNum.toArray());

            if (result){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String str4 = readLine();

                try {
                    int choice = Integer.parseInt(str4);
                    if (choice < 1 || choice > 2) {
                        throw new IllegalArgumentException();
                    }
                    if (choice == 1){
                        Application.game();
                    } else {
                        System.out.println("게임 종료");
                    }
                } catch (NumberFormatException ex4) {
                    ex4.printStackTrace();
                }
            } else {
                int strike = 0;
                int ball = 0;
                for (int i = 0; i < computer.size(); i++) {
                    if (Objects.equals(computer.get(i), splitNum.get(i))) {
                        strike += 1;
                    }
                }
                for (Integer integer : computer) {
                    for (Integer value : splitNum) {
                        if (Objects.equals(integer, value)) {
                            ball += 1;
                        }
                    }
                }
                if (strike == 0 && (ball - strike) == 0) {
                    System.out.println("낫싱");
                } else if (strike != 0 && (ball - strike) == 0){
                    System.out.println(strike + "스트라이크 ");
                } else if (strike == 0){
                    System.out.println((ball - strike) + "볼");
                } else {
                    System.out.println((ball - strike) + "볼 " + strike + "스트라이크");
                }

                while (strike != 3) {
                    strike = 3;
                    System.out.print("숫자를 입력해주세요 : ");
                    String inputNum2 = readLine();
                    try {
                        int changeNum2 = Integer.parseInt(inputNum2);
                        if (changeNum2 < 111 || changeNum2 > 999) {
                            throw new IllegalArgumentException();
                        }

                        ArrayList<Integer> splitNum2 = new ArrayList<>();
                        while (changeNum2 > 0) {
                            splitNum2.add(changeNum2 % 10);
                            changeNum2 /= 10;
                        }

                        Collections.reverse(splitNum2);

                        boolean result2 = Arrays.equals(computer.toArray(), splitNum2.toArray());

                        if (result2) {
                            System.out.println("3스트라이크");
                            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                            String str5 = readLine();

                            try {
                                int choice = Integer.parseInt(str5);
                                if (choice < 1 || choice > 2) {
                                    throw new IllegalArgumentException();
                                }
                                if (choice == 1) {
                                    Application.game();
                                } else {
                                    System.out.println("게임 종료");
                                }
                            } catch (NumberFormatException ex4) {
                                ex4.printStackTrace();
                            }

                        } else {
                            strike = 0;
                            ball = 0;
                            for (int l = 0; l < computer.size(); l++) {
                                if (Objects.equals(computer.get(l), splitNum2.get(l))) {
                                    strike += 1;
                                }
                            }

                            for (Integer integer : computer) {
                                for (Integer value : splitNum2) {
                                    if (Objects.equals(integer, value)) {
                                        ball += 1;
                                    }
                                }
                            }

                            if (strike == 0 && (ball - strike) == 0) {
                                System.out.println("낫싱");
                            } else if (strike != 0 && (ball - strike) == 0){
                                System.out.println(strike + "스트라이크 ");
                            } else if (strike == 0){
                                System.out.println((ball - strike) + "볼");
                            }  else {
                                System.out.println((ball - strike) + "볼 " + strike + "스트라이크");
                            }
                        }
                    } catch (NumberFormatException ex6) {
                        ex6.printStackTrace();
                    }
                }
            }
        } catch (NumberFormatException ex5) {
            ex5.printStackTrace();
        }
    }
}
