package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 입력 받은 내용을 처리하거나 출력하기
        List<Integer> computer = new ArrayList<>();
        String tf = "1";
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 정답을 맞출 때까지 반복하기
        while(true){
            // 처음 시작 또는 정답을 맞춘 후 재시작할 때 랜덤 숫자 생성
            if(tf.equals("1")) {
                // 입력 받은 내용을 처리하거나 출력하기
                computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                tf = "";
                System.out.println(computer);
            }

            // 맞추는 숫자 입력하기
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();

            // 숫자가 3자리가 아닐경우 예외처리하기
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("예외가 발생했습니다.");
            }

            System.out.println("사용자가 입력한 값: " + userInput);
            String str[] = userInput.split("");
            
            // 동일한 숫자가 있을 경우 예외처리하기
            List<String> list = new ArrayList<>();

            int num = 0;

            while (num != 3) {
                if (!list.contains(str[num])) {
                    list.add(str[num]);
                }
                num++;
            }

            if(list.size() < 3){
                throw new IllegalArgumentException("예외가 발생했습니다.");
            }
            
            // 스트라이크, 볼 개수 세기
            int strike = 0;
            int ball = 0;
            
            for(int i=0; i<userInput.length(); i++){
                if(computer.get(i) == Integer.parseInt(str[i])){
                    strike++;
                } else if(computer.contains(Integer.parseInt(str[i]))){
                    ball++;
                }
            }

            if(ball != 0){
                System.out.print(ball + "볼 ");
            }

            if(strike != 0){
                System.out.print(strike + "스트라이크");
            }

            if(ball == 0 && strike == 0){
                System.out.print("낫싱");
            }

            System.out.println();

            // 정답을 맞췄을 경우 게임 종료 또는 재시작 조건 실행
            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                tf = readLine();
                if(tf.equals("2")) break;
            }
        }
    }
}