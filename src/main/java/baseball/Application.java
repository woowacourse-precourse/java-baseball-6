package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static int gameNum;
    public static Scanner sc = new Scanner(System.in);
    public static List<Integer> computer = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final int START_NUM = 1;
        gameNum = START_NUM;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameNum == START_NUM) {
            makeComputerNumber();
            startGame();
        }
    }
    //컴퓨터 랜덤 숫자 3개를 만드는 메소드
    public static void makeComputerNumber() {
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.print("컴퓨터가 만든 숫자 : ");
        for(int i : computer) System.out.println(i);
        System.out.println();
    }
    public static void startGame() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = sc.next();
        if(!check(input)) throw new IllegalArgumentException();
        //게임 로직 시작
        numberBasketballGame(input);
    }
    //사용자가 제대로된 값을 입력했는지 확인하는 메소드
    public static boolean check(String str){
        //(1) 길이가 3자리가 아니면 false
        if(str.length() != 3) {
            System.out.println("길이가 맞지 않아요");
            return false;
        }

        int[] nums = new int[10];
        for(int i=0; i<str.length(); i++) {
            //(2) 숫자가 아니면 false
            if(!Character.isDigit(str.charAt(i))) {
                System.out.println("숫자가 아니에요");
                return false;
            }
            //(3) 서로 다른 3개 숫자가 아니면 false
            int num = str.charAt(i) - '0';
            if(nums[num] == 1) {
                System.out.println("이미 숫자가 존재해요");
                return false;
            }
            nums[num]++;
        }
        return true;
    }
    public static void numberBasketballGame(String input) {
        //배열에 넣기
        List<Integer> users = new ArrayList<>();
        int strikeCnt = 0;
        int ballCnt = 0;
        for(int i=0; i<3; i++){
            int userNum = input.charAt(i) - '0';
            for(int j=0; j<3; j++){
                int computerNums = computer.get(j);
                if(userNum == computerNums) {
                    if(i == j) strikeCnt++;
                    else ballCnt++;
                }
            }
        }
        printResult(strikeCnt, ballCnt);
        if (strikeCnt == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameNum = Integer.parseInt(sc.next());
        }
    }
    private static void printResult(int strike, int ball){
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0) sb.append("낫싱");
        else {
            if(ball != 0) sb.append(ball).append("볼 ");
            if(strike != 0) sb.append(strike).append("스트라이크");
        }
        System.out.println(sb);
    }
}
