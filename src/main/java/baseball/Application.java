package baseball;
// 코드 정렬: crtl + alt + L

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private Application(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> randomPick(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public String getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        /// 4-1. "345" -> 345 -> 3, 4, 5 -> {3, 4, 5}
        String inputStr = Console.readLine(); // "345"
        return inputStr;
    }
    public static boolean checkIsValidate(String inputStr){
        int str2Number = 0; // 345

        try { // 예외를 처리하길 원하는 실행코드
            if (inputStr.length() != 3) // 성공
                throw new IllegalArgumentException("IllegalArgumentException 3자리 수");
        } catch (IllegalArgumentException e1) {
            System.out.println("IllegalArgumentException 3자리 수");
            return false;
        } ;
        try {
            str2Number = Integer.parseInt(inputStr);
        } catch (NumberFormatException eN) {    //숫자 아닌게 섞였을 때 (현재 공백 '12 ', '12a' 실패
            try {
                throw new IllegalArgumentException("IllegalArgumentException 숫자 아닌 문자");
            } catch (IllegalArgumentException e2) {
                System.out.println("IllegalArgumentException 숫자 아닌 문자");
                return false;
            }
        }

        int num1 = str2Number / 100; // 3, 백의 자리
        int num2 = (str2Number % 100) / 10; // 4, 10의 자리
        int num3 = (str2Number % 100) % 10; // 5, 1의 자리
        List<Integer> nums = new ArrayList<>();
        nums.add(num1); // {3}
        nums.add(num2); // {3, 4, 5?
        nums.add(num3); // {3, 4, 5}

        try{
            if (nums.size() != nums.stream().distinct().count()) // 중복 숫자가 있을 때
                throw new IllegalArgumentException("IllegalArgumentException 중복 숫자");
        }catch (IllegalArgumentException e2){
            System.out.println("IllegalArgumentException 중복 숫자");
            return false;
        }
        try{
            if (nums.contains(0)) // 1~9가 아닐 때, 즉 0있으면 //성공 ex) 012, 120
            {
                throw new IllegalArgumentException("IllegalArgumentException 1 ~ 9 이내 숫자로");
            }
        }catch (IllegalArgumentException e3){
            System.out.println("IllegalArgumentException 1 ~ 9 이내 숫자로");
            return false;
        }

        return true;
    }

    public List<Integer> Str2IntList(String inputStr){

        int str2Number = Integer.parseInt(inputStr);

        int num1 = str2Number / 100; // 3, 백의 자리
        int num2 = (str2Number % 100) / 10; // 4, 10의 자리
        int num3 = (str2Number % 100) % 10; // 5, 1의 자리
        List<Integer> nums = new ArrayList<>();
        nums.add(num1); // {3}
        nums.add(num2); // {3, 4, 5?
        nums.add(num3); // {3, 4, 5}

        return nums;
    }

    public int[] checkIsBallOrStrike(List<Integer> user, List<Integer> computer){
        int[] Count = new int[] {0, 0, 0};

        for (int index = 0; index < user.size();index++) {
            if (computer.contains(user.get(index))) { // 사용자 입력숫자가 컴퓨터 랜덤 리스트에 존재하면 스트라이크인지 볼인지 확인
                if (index == computer.indexOf(user.get(index))) { // 사용자 입력숫자 자리와 컴퓨터 랜덤 리스트에서의 같으면
                    Count[0] += 1; // 스트라이크
                } else {
                    Count[1] += 1; // 볼 , 4,5
                }
            } else            // 존재하지 않으면 nothing +1
                Count[2] += 1; //3
        }
        return Count;
    }
    public void printMent(int [] countArray) {
        /// 5-1. 함수에 필요한 변수 선언
        int strikeCount = countArray[0];
        int ballCount = countArray[1];
        int nothingCount = countArray[2];

        String ballMent = Integer.toString(ballCount) + "볼";
        String strikeMent = Integer.toString(strikeCount) + "스트라이크";

        // 3 스트라이크
        if (strikeCount == 3) {
            System.out.println(strikeMent);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        // 혼합
        else if (ballCount > 0 && strikeCount > 0)
            System.out.println(ballMent + " " + strikeMent);
        // 볼만 있을 경우
        else if (ballCount > 0 && strikeCount == 0)
            System.out.println(ballMent);
        // 스트라이크만 있을 경우
        else if (strikeCount > 0 && ballCount == 0)
            System.out.println(strikeMent);
        //낫씽
        else if (nothingCount == 3)
            System.out.println("낫씽");
    }
    /*public static void exceptionHandling(String wrongInput){
        // 잘못된 값 입력할 경우 IllegalArgumentException을 발생 후 애플리케이션 종료
        // IllegalArgumentException:
        // 예외 메서드가 허가되지 않거나 부적절한 argument를 받았을 경우에 던져지는/던질 수 있는 예외
        // 적절하지 못한 인자를 메소드에 넘겨주었을 때
        // ex) 숫자가 3개가 아님, 숫자가 아닌 문자가 섞여있음, 공백이 있음(0), 1~9 숫자가 아님, 중복 숫자
        try { // 예외를 처리하길 원하는 실행코드
        } catch (IllegalArgumentException e1) {
            System.out.println();
            return;
        }
    }*/

    public static boolean askWannaRegame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cmd =  Console.readLine();
        boolean wannaExit = false;

        switch (cmd) {
            case "1": // 새로 시작
                Application.main(new String[]{});
                break;
            case "2": // 종료
                wannaExit = true;
                break;
            default: // 예외 처리
                try{
                    throw new IllegalArgumentException("IllegalArgumentException");
                } catch (IllegalArgumentException e){
                    System.out.println("IllegalArgumentException 예외 발생. 종료합니다.");
                    wannaExit = true;
                }
        }
        return wannaExit;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application program = new Application();

        /// newGame 분기점 (재시작 시)
        // 1. 컴퓨터가 1 ~ 9 중 3개의 임의의 수 차출
        // 2. 배열에 3개의 숫자를 넣는다
        List<Integer> PC = program.randomPick();

        boolean tryAgain = true;
        boolean TryingToExit = false;

        // 반복문
        while(tryAgain) {
            // 3. 사용자가 세 개의 수 입력
            String userInput = program.getUserInput();
            // 4. 사용자 입력 문자열 -> 정수형 배열 변환 (목적: 3,4,5 가 {4,5,6}에 있는가?)
            // 4-1. 예외 처리
            if (!checkIsValidate(userInput)){ // 사용자 입력이 유효하지 않으면
                return;         // 종료
            }
            // 4-2. 입력 받은 배열 정수형 리스트로 변환
            List<Integer> user = program.Str2IntList(userInput);

            // 5. 컴퓨터 수열과 사용자 입력 수열 비교해서 낫씽, 볼, 스트라이크 확인
            int [] countArray = program.checkIsBallOrStrike(user,PC);
            int strikeCount = countArray[0];
            // 6. 결과 출력
            program.printMent(countArray);
            // 7. 탈출문 : 3스트라이크 아닐 시 반복
            if (strikeCount == 3)  {
                tryAgain = false;
            }
        }

        //8. 재시작 or 종료
        TryingToExit = askWannaRegame();
        if(TryingToExit)
            return;
    }
}