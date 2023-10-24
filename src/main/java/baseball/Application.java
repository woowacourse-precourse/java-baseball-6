package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

    }
    public void RandomNumberOfComputer() {
        List<Integer> RandomNumberOfComputer = new ArrayList<>();
        while RandomNumberOfComputer.size() < 3 {
            int number = Randoms.pickNumerInRange(1, 9);
            if (!RandomNumberOfComputer.contains(number)) {
                RandomNumberOfComputer.add(number);
                }
            }
        }
    public ArrayList<integer> InputNumber() {
        string NumberOfUser = Console.readLIne();
        return NumberOfUser;
    }
    public LengthException() {
        if (s.length() != 3) {
            throw new IllegalArgumentException("자릿수가 맞지 않음");
        }
    }

    private int count;
    public ComparisonOfNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        int Num = InputNumber();
        int HundredsOfNum = Num / 100;
        int TensOfNum = (Num % 100) / 10;
        int UnitsNum = Num % 10;
        int Strike;
        int Ball;


    }

}
