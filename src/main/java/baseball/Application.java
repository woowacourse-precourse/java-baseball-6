package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        System.out.println(computer);



        System.out.print("숫자를 입력해주세요 : ");
        //Application.inputNum();

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
                for (int i = 0; i < computer.size(); i++) {
                    if (computer.get(i) == splitNum.get(i)) {
                        strike += 1;
                    }
                }
                for (int j = 0; j < computer.size(); j++) {
                    for (int k = 0; k < splitNum.size(); k++) {
                        if (computer.get(j) == splitNum.get(k)) {
                            ball += 1;
                        }
                    }
                }
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(strike + "스트라이크 " + (ball - strike) + "볼");
                }
                // ------------------------------------------------------------------------
                while (strike != 3) {
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

                        if (result2 == true) {
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
                                    break;
                                }
                            } catch (NumberFormatException ex4) {
                                ex4.printStackTrace();
                            }

                        } else {
                            int strike2 = 0;
                            int ball2 = 0;
                            for (int l = 0; l < computer.size(); l++) {
                                if (computer.get(l) == splitNum2.get(l)) {
                                    strike2 += 1;
                                }
                            }
                            for (int m = 0; m < computer.size(); m++) {
                                for (int n = 0; n < splitNum2.size(); n++) {
                                    if (computer.get(m) == splitNum2.get(n)) {
                                        ball2 += 1;
                                    }
                                }
                            }
                            if (strike2 == 0 && ball2 == 0) {
                                System.out.println("낫싱");
                            } else {
                                System.out.println(strike2 + "스트라이크 " + (ball2 - strike2) + "볼");
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
/*
    public static void inputNum() {
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
            boolean result = Arrays.equals(ComputerNumber.randomNumber().toArray(), splitNum.toArray());

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
                for (int i = 0; i < ComputerNumber.randomNumber().size(); i ++) {
                    if (ComputerNumber.randomNumber().get(i) == splitNum.get(i)) {
                        strike += 1;
                    }
                }
                for (int j = 0; j < ComputerNumber.randomNumber().size(); j++) {
                    for (int k = 0; k < splitNum.size(); k++){
                        if (ComputerNumber.randomNumber().get(j) == splitNum.get(k)) {
                            ball += 1;
                        }
                    }
                }
                if (strike == 0 && ball == 0){
                    System.out.println("낫싱");
                } else {
                    System.out.println(strike + "스트라이크 " + (ball-strike) + "볼");
                }
                if (strike != 3){

                }
            }
        } catch (NumberFormatException ex5) {
            ex5.printStackTrace();
        }
    }

 */
}
