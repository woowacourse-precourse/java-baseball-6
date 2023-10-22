package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Computer{
    private final List<Integer> computerNum;

    public Computer(){
        this.computerNum = pickNumbers();
    }

    public List<Integer> pickNumbers(){
        List<Integer> arr = new ArrayList<>();
        while (arr.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!arr.contains(randomNumber)) {
                arr.add(randomNumber);
            }
        }
        return arr;
    }
    public int[] compareNum(List<Integer> user){
        int strike = 0, ball = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(Objects.equals(computerNum.get(i), user.get(j))){
                    if(i == j) strike++;
                    else ball++;
                }
            }
        }
        return new int[]{strike, ball};
    }
}

class User {
    private final List<Integer> userNum;
    public User() {
        this.userNum = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try{
            isValidInput(input);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    public List<Integer> getUserNum() {
        return userNum;
    }

    private void isValidInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }

        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("1과 9 사이의 숫자를 입력해주세요.");
            }

            int num = Character.getNumericValue(c);
            if (userNum.contains(num)) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
            }
            userNum.add(num);

        }
    }
}

class Game {
    private Computer computer;

    public Game() {
        this.computer = new Computer();
    }

    public void start() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            getUserInput();
            if(!askGameProgress()) break;
        }
    }

    private boolean getUserInput() {
        while(true){
            User user = new User();
            int[] result = computer.compareNum(user.getUserNum());

            if (result[0] == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            printGameResult(result);
        }
    }

    private void printGameResult(int[] result) {
        if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        } else if (result[0] > 0 && result[1] == 0) {
            System.out.println(result[0] + "스트라이크");
        } else if (result[0] == 0 && result[1] > 0) {
            System.out.println(result[1] + "볼");
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }
    }

    private boolean askGameProgress() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = Integer.parseInt(Console.readLine());

        if(num == 1) computer = new Computer();
        else if(num == 2) return false;
        else throw new IllegalArgumentException("잘못된 입력입니다. 게임 재시작은 1, 종료는 2 입니다.");

        return true;
    }
}
public class Application {
    public static void main(String[] args) {
        new Game().start();
    }
}