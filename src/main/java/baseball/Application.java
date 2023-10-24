package baseball;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    private static final int NumberLength = 3; // 컴퓨터 숫자 개수
    private static final int GameOver = NumberLength;
    private static final boolean Play = true;
    private static final boolean Stop = false;

    private static boolean game = Play;
    public static void main(String[] args) {
        StartBaseball(); // 숫자야구 시작
    }


    public static void StartBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game = Play;
        while(game){
            List<Integer> ComputerNumber = GenerateNumber();// 컴퓨터 숫자 랜덤 설정
            int gameResult = 0;

            while(gameResult != GameOver) {
                List<Integer> MyNumber = GuessNumber();
                gameResult = CompareNumber(ComputerNumber, MyNumber);
                CheckStrike(gameResult);
            }
        }
    }



    public static List<Integer> GenerateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NumberLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> GuessNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputnumber = Console.readLine();
        List<Integer> MyNumber = new ArrayList<>();
        if(inputnumber.length() != NumberLength) throw new IllegalArgumentException("You should input " + NumberLength + " numbers!");
        for (int i = 0; i < NumberLength; i++) {
            char DigitToChar = inputnumber.charAt(i);
            if(DigitToChar < '1' || DigitToChar > '9') throw new IllegalArgumentException("You should input Integers!");
            int digit = Character.getNumericValue(DigitToChar);
            MyNumber.add(digit);
        }
        return MyNumber;
    }


    public static int CompareNumber(List<Integer> ComputerNumber, List<Integer> MyNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NumberLength; i++) {
            if (ComputerNumber.get(i).equals(MyNumber.get(i))) {
                strike++;
            } else if (MyNumber.contains(ComputerNumber.get(i))) {
                ball++;
            }
        }
        if(ball ==  0 && strike == 0){
            System.out.println("낫싱");
        }
        if(ball != 0) {
            System.out.print(ball + "볼 ");
            if(strike == 0) System.out.println();
        }
        if(strike !=0) {
            System.out.println(strike + "스트라이크");
        }

        return strike;
    }

    public static void CheckStrike(int gameResult) {
        if(gameResult == GameOver) {
            System.out.println(NumberLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            NextOrStop();
        }
    }



    public static void NextOrStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputnumber = Console.readLine();
        int input = Integer.parseInt(inputnumber);
        if(inputnumber.length() != 1 || (input != 1 && input != 2)) throw new IllegalArgumentException("You should input 1 or 2");
        if(input == 1) game = Play;
        if(input == 2) game = Stop;
    }

    }
