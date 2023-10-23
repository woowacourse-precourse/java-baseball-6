package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static Nums nums = new Nums();

    // 상대방(컴퓨터) 숫자
    public static void getComputerNums(){   // 나와 상대방(컴퓨터)의 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        nums.setComputer(computer);
    }

    // 내 숫자
    public static void getMyNums(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        // 숫자 개수가 3개가 아닐 경우 예외처리
        if (inputNumber.length() != 3){
            throw new IllegalArgumentException();
        }
        List<Integer> mine = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(inputNumber.charAt(i));
            if (mine.contains(num)) {  // 중복입력 예외처리
                throw new IllegalArgumentException();
            }else mine.add(num);
        }
        nums.setMine(mine);
    }

    public static int getGameResultJudgment(List<Integer> computer, List<Integer> mine){
        // 스트라이크 개수 세기
        int strike = 0;
        int flag = 1;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(mine.get(i))){
                strike ++;
            }
        }
        // 볼 개수 세기
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && computer.get(i).equals(mine.get(j))){
                    ball ++;
                }
            }
        }
        getResult(strike, ball);
        if (strike == 3) flag = 2;
        return flag;
    }

    public static void getResult(int strike, int ball){
        if (ball == 0 && strike == 0) System.out.println("낫싱");
        else if (ball > 0 && strike == 0){
            System.out.printf("%d볼", ball);
            System.out.println();
        }
        else if(ball == 0 && strike > 0){
            System.out.printf("%d스트라이크", strike);
            System.out.println();
        }
        else{
            System.out.printf("%d볼 %d스트라이크", ball, strike);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int flag = 1;
        getComputerNums();
        while (flag >= 1) {
            if (flag == 2){  // 다시하기 분기
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int ans = Integer.parseInt(Console.readLine());
                if (ans == 1) {
                    getComputerNums();
                    flag = ans;
                }
                else if(ans == 2){
                    flag = 0;
                    System.out.println("게임이 종료되었습니다.");
                }

            }
            else if (flag == 1){
                getMyNums();
                flag = getGameResultJudgment(nums.getComputer(), nums.getMine());
            }
        }
    }
}
