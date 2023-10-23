package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    // 중복 검사 함
    public static boolean isDuplicationExist(String randomNum) {
        ArrayList<Character> randomNumList = new ArrayList<Character>();
        for (int i=0; i<3; i++){
            randomNumList.add(randomNum.charAt(i));
        }
        Set<Character> randNumSet = new HashSet<>(randomNumList);
        if (randNumSet.size()!=3) {
            return true;
        }
        return false;
    }

    public static boolean isCharacterExist(String randomNum) {
        try{
            Integer.parseInt(randomNum);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }

    // 게임 시작 함수
    public static void startBaseball() {
        int strike = 0;

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터가 1~9까지의 서로 다른 임의의 수 3개 선택
        String computer = "";
        for (int i=0;i<3;i++) {
            computer+= Integer.toString(Randoms.pickNumberInRange(1, 9));
        }

        // 3스트라이크가 될 때까지 반복
        while (strike<3) {

            // 플레이어에게 숫자 입력받기
            System.out.println("숫자를 입력해주세요 : ");
            String randomNum = Console.readLine();

            // 플레이어가 입력한 수가 3자리 수가 아닌 경우 예외처리
            if (randomNum.length()!=3) {
                throw new IllegalArgumentException();
            }

            // 플레이어가 입력한 수에 중복되는 수가 존재할 경우 예외처리
            if (isDuplicationExist(randomNum)){
                throw new IllegalArgumentException();
            }

            // 플레이어가 입력한 수에 문자가 있는 경우 예외처리
            if (isCharacterExist(randomNum)){
                throw new IllegalArgumentException();
            }

            strike = 0;
            int ball = 0;

            // 컴퓨터가 임의로 뽑은 수 3개와 플레이어가 입력한 숫자 3개 비교
            for (int i=0; i<3; i++) {
                int index = 0;
                String number = Character.toString(computer.charAt(i));
                if (randomNum.contains(number)){
                    index = randomNum.indexOf(number);
                    if (i==index) {
                        strike+=1;
                    } else {
                        ball+=1;
                    }
                }
            }

            // 스트라이크, 볼, 낫싱 개수 세기
            if (strike==0 && ball==0) {
                System.out.println("낫싱");
            } else if (ball==0) {
                System.out.println(strike+"스트라이크");
            } else if (strike==0) {
                System.out.println(ball+"볼");
            } else {
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }
        }

        // 3스트라이크인 경우, 게임 종료
        if (strike==3) {
            // 게임 종료 문구 출력
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            // 재시작 또는 종료 입력받기
            String restart = Console.readLine();
            if ("1".equals(restart)) {
                startBaseball();
            } else if("2".equals(restart)) {
                System.out.println("게임 종료");
            }
        }
    }
    public static void main(String[] args) {

        startBaseball();

    }
}
