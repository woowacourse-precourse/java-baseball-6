package baseball;

import java.util.*;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static List<Integer> playerNum(String playerString) {
        List<Integer> player = new ArrayList<>();
        int[] playerInt = Stream.of(playerString.split(""))
            .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < playerInt.length; i++) {
                if (player.contains(playerInt[i])) {
                    throw new IllegalArgumentException("숫자가 중복되었습니다.");
                }
                player.add(playerInt[i]);
            }

        return player;
    }

    public static int[] checkBallAndStrike(List<Integer> computer, List<Integer> player) {
        int[] bsArr = {0, 0};
        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < computer.size(); j++)
                if (i != j && computer.get(i) == player.get(j))
                    bsArr[0]++;
        }
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == player.get(i))
                bsArr[1]++; 
        }
        return bsArr;
    }

    public static void printResult(int[] bsArr) {
        if(bsArr[0] > 0 || bsArr[1] > 0) {
            if (bsArr[0] > 0)
                System.out.print(bsArr[0] + "볼 ");
            if (bsArr[1] > 0)
                System.out.print(bsArr[1] + "스트라이크");
            System.out.println();
        }
        else
            System.out.println("낫싱");
    }

    public static boolean isGameRestart(int option) {
        if (option == 1)
            return true;
        else if (option == 2){
            System.out.println("숫자 야구 게임을 종료합니다.");
            return false;
        }
        else throw new IllegalArgumentException("옵션에 존재하지 않는 숫자를 입력했습니다.");

    }

    public static boolean isAllStrike(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return false;
        }
        else 
            return true;
    }

    public static void main(String[] args) {
        int option = 1;
        String str;
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(isGameRestart(option)) {
            int[] arr = {0, 0};

            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while(isAllStrike(arr[1])) {
                System.out.print("숫자를 입력해주세요 : ");
                str = Console.readLine();
                if (str.contains("0")) {
                    throw new IllegalArgumentException("0을 입력할 수 없습니다.");
                }
                if (str.contains(" ")) {
                    throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
                }
                if (str.length() != computer.size()) {
                    throw new IllegalArgumentException("숫자 3개를 입력하세요.");
                }

                player = playerNum(str);
                for (int i = 0; i < player.size(); i++) {

                }
                arr = checkBallAndStrike(computer, player);
                printResult(arr);
                player.clear();
            }
            option = Integer.parseInt(Console.readLine());
            computer.clear();
        }
    }
}
