package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int SIZE = 3;

    // 시작문구를 출력하는 기능
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 사용자의 숫자입력을 알리는 기능
    public void printUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public String numberInput() {
        String input_number = Console.readLine();

        return input_number;
    }

    // 입력받은 숫자를 형변환하는 기능
    public int[] stringToIntArray(String input) {
        int[] intArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            intArray[i] = digit;
        }
        return intArray;
    }

    public List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 입력받은 숫자의 볼과 스트라이크 여부를 체킹하는 기능
    public int[] checkStrikeAndBall(int[] input_number, List<Integer> computer_number) {
        int[] strike_ball = {0,0}; // {볼, 스트라이크}

        for (int input_index=0; input_index<SIZE; input_index++) {
            for (int comp_index=0; comp_index<SIZE; comp_index++) {
                if (input_number[input_index] == computer_number.get(comp_index)) {
                    if(input_index == comp_index) {
                        strike_ball[1] += 1;
                    } else {
                        strike_ball[0] += 1;
                    }
                }
            }
        }
        return strike_ball;
    }

    // 힌트를 출력하는 기능
    public void printStrikeBall(int[] strike_ball) {
        if (strike_ball[0] != 0 && strike_ball[1] == 0) { // 볼만 있는 경우
            System.out.println(strike_ball[0] + "볼");}

        if(strike_ball[0] == 0 && strike_ball[1] != 0) { // 스트라이크만 있는 경우
            System.out.println(strike_ball[1] + "스트라이크");}

        if(strike_ball[0] == 0 && strike_ball[1] == 0) { // 하나도 없는 경우
            System.out.println("낫싱");}

        System.out.println(strike_ball[0] + "볼 " + strike_ball[1] + "스트라이크"); // 스트라이크 볼 둘다 있는 경우
    }

    // 정답을 맞췄을 때 재시작의 여부를 묻는 기능
    public void printGameRestart() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void main(String[] args) {


    }
}
