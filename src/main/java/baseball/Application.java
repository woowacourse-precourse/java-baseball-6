package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        try {
            while (true) {
                String comPuts = generateComputerNumber();
                boolean gameEnded = false;

                while (!gameEnded) {
                    System.out.print("숫자를 입력해주세요 : ");

                    String users = getUserNums();

                    int[] result = compareNumbers(Integer.parseInt(comPuts), Integer.parseInt(users));

                    if (result[1] == 3) {
                        System.out.println("컴퓨터:" + comPuts);
                        System.out.println(result[1] + "스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        gameEnded = true;
                    } else if (result[0] == 0 && result[1] == 0) {
                        System.out.println("컴퓨터:" + comPuts);
                        System.out.println("낫싱");
                    } else
                        {
                            if(result[0]>0 && result[1]>0){
                            System.out.println("컴퓨터:" + comPuts);
                            System.out.println(result[0] + "볼 " + result[1] + "스트라이크 ");
                        } else if (result[0] == 0) {
                            System.out.println("컴퓨터:" + comPuts);
                            System.out.println(result[1] + "스트라이크");
                        }  else if(result[1] == 0){
                            System.out.println("컴퓨터:" + comPuts);
                            System.out.println(result[0] + "볼");
                        }
                    }

                } // while

                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
                int choice = Integer.parseInt(readLine());
                if (choice != 1) {
                    break;
                }
            } // 게임을 시작하는 구간
        } catch (Exception e) {
           throw e;
        } // try-catch

        System.out.println("게임을 종료합니다.");
    } // main

    public static String generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            } // if
        } // while

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(computer.get(i));
        } // for

        String comNums = sb.toString();
        return comNums;
    } // generateComputerNumber

    public static String getUserNums() throws IllegalArgumentException{
        while (true) {
            try {
                String puts = Console.readLine();

                if (puts.length() > 3) {
                    throw new IllegalArgumentException();

                } else {
                    Set<Character> putChars = new HashSet<>();

                    for (int i = 0; i < 3; i++) {
                        char num = puts.charAt(i);
                        if (putChars.contains(num)) {
                            throw new IllegalArgumentException();
                        } // 중복을 허용하지 않는 set을 사용해, 중복내용이 발견되면 예외 발생시키고 종료
                        putChars.add(num);
                    } // for

                    return puts;
                } // if

            } catch (IllegalArgumentException e) {
                throw e;
            } // try-catch
        } // while
    } // getUserNums

    public static int[] compareNumbers(int computerNumber, int userNumber) {
        int[] result = new int[2]; // result[0] = 볼, result[1] = 스트라이크
        String computerStr = Integer.toString(computerNumber);
        String userStr = Integer.toString(userNumber);

        for (int i = 0; i < 3; i++) {
            if (userStr.charAt(i) == computerStr.charAt(i)) { // 숫자의 값과 위치가 같다면
                result[1]++; // 스트라이크 적립
            } else if (computerStr.contains(String.valueOf(userStr.charAt(i)))) { // 컴퓨터의 숫자들 중에 유저의 숫자가 포함되어 있다면
                result[0]++; // 볼 적립
            } // if-else
        } // 반복문으로 두 문자열의 내용물을 비교

        return result;
    } // 컴퓨터의 수와 입력받은 수를 비교하는 함수
} // end class