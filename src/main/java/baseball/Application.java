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
            List<Integer> ComputerNumber = GenerateNumber();// 컴퓨터 숫자 랜덤 생성
            int gameResult = 0;

            while(gameResult != GameOver) { // gameResult 가 Gameover 가 되면 종료
                List<Integer> MyNumber = GuessNumber(); // 예측할 숫자 입력
                gameResult = CompareNumber(ComputerNumber, MyNumber); // 컴퓨터의 숫자와 예측한 숫자 비교
                Check3Strike(gameResult); // 3스트라이크인지 확인
            }
        }
    }



    public static List<Integer> GenerateNumber() {// 컴퓨터 번호 랜덤 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NumberLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> GuessNumber() {// 예측할 숫자 입력
        System.out.print("숫자를 입력해주세요 : ");
        String inputnumber = Console.readLine();
        List<Integer> MyNumber = new ArrayList<>();
        if(inputnumber.length() != NumberLength)//예외출력
            throw new IllegalArgumentException("You should input " + NumberLength + " numbers!");
        for (int i = 0; i < NumberLength; i++) {
            char DigitToChar = inputnumber.charAt(i);
            if(DigitToChar < '1' || DigitToChar > '9')//예외출력
                throw new IllegalArgumentException("You should input Integers!");
            int digit = Character.getNumericValue(DigitToChar);
            MyNumber.add(digit);
        }
        return MyNumber;
    }

    //숫자 비교
    public static int CompareNumber(List<Integer> ComputerNumber, List<Integer> MyNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NumberLength; i++) {
            if (ComputerNumber.get(i).equals(MyNumber.get(i))) {
                strike++;//같은 숫자가 같은 위치에 있으면 strike
            } else if (MyNumber.contains(ComputerNumber.get(i))) {
                ball++;//위치는 다르지만 같은 숫자가 있으면 ball
            }
        }
        PrintResult(ball, strike);//볼과 스트라이크의 결과 출력
        return strike;
    }
    public static void PrintResult(int ball, int strike){//볼과 스트라이크의 결과 출력
        if(ball ==  0 && strike == 0){
            System.out.println("낫싱"); // 아무것도 없다면 낫싱 출력
        }
        if(ball != 0) { // 볼이 있다면 출력
            System.out.print(ball + "볼 ");
            if(strike == 0) System.out.println();// 만약 스트라이크가 없다면 다음 행으로
        }
        if(strike !=0) {// 스트라이크가 있다면 출력
            System.out.println(strike + "스트라이크");
        }
    }

    public static void Check3Strike(int gameResult) {//3스트라이크 확인
        if(gameResult == GameOver) {// Gameover 문구 출력 후 재시작할 것인지 확인(NextOrStop)
            System.out.println(NumberLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            NextOrStop();
        }
    }



    public static void NextOrStop() {//게임의 재시작 여부 확인
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputnumber = Console.readLine();
        int input = Integer.parseInt(inputnumber);
        if(inputnumber.length() != 1 || (input != 1 && input != 2)) //예외출력
            throw new IllegalArgumentException("You should input 1 or 2");
        if(input == 1) game = Play;// 1을 입력받으면 재시작
        if(input == 2) game = Stop;// 2를 입력받으면 종료
    }

    }
