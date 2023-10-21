/*
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임

- 같은 수가 같은 자리에 있으면 스트라이크
- 같은 수가 다른 자리에 있으면 볼,
- 같은 수가 전혀 없으면 낫싱 이다.

ex) 상대방의 수가 425 일때
123 : 1스트라이크
456 : 1볼 1스트라이크
789 : 낫싱

이 과정을 반복하여 컴퓨터가 선택한 숫자를 모두 맞히면 게임이 종료된다

입력: 서로 다른 3자리의 수, 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
출력: 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

우선 문제를 해결하기에 앞서 필요한 조건들을 나열하자면

잘못된 값을 입력하면 IllegalArgumentException 를 발생시키고 종료


 */
package baseball;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    private static final int TotalComputer = 3; // 컴퓨터 숫자 개수
    private static final int GameOver = TotalComputer;
    private static final boolean Play = true;
    private static final boolean Stop = false;

    private static boolean game = Play;
    public static void main(String[] args) {
        StartBaseball(); // 숫자야구 시작
    }


    public static void StartBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");

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
        while (computer.size() < TotalComputer) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //System.out.println(computer); // computernumber 확인용 출력문구
        return computer;
    }
    public static List<Integer> GuessNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputnumber = Console.readLine();
        List<Integer> MyNumber = new ArrayList<>();

        for (int i = 0; i < TotalComputer; i++) {
            char DigitToChar = inputnumber.charAt(i);
            int digit = Character.getNumericValue(DigitToChar);
            MyNumber.add(digit);
        }

        System.out.println(MyNumber);
        return MyNumber;
    }


    public static int CompareNumber(List<Integer> ComputerNumber, List<Integer> MyNumber) {
        int ball = 0;
        int strike = 0;

        for (Integer num : ComputerNumber) {
            if (MyNumber.contains(num)) {
                ball++;
            }
        }

        for (int i = 0; i < TotalComputer; i++) {
            if (ComputerNumber.get(i).equals(MyNumber.get(i))) {
                strike++;
            }
        }

        ball -= strike;
        System.out.print(ball + "볼 ");
        System.out.println(strike + "스트라이크");
        return strike;
    }

    public static void CheckStrike(int gameResult) {
        if(gameResult == GameOver) {
            System.out.println(TotalComputer + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            NextOrStop();
        }
    }



    public static void NextOrStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputnumber = Console.readLine();
        int input = Integer.parseInt(inputnumber);
        if(input == 1) game = Play;
        if(input == 2) game = Stop;
    }

    }
