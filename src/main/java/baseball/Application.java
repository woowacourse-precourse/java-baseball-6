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



    public static void main(String[] args) {


    }
}
