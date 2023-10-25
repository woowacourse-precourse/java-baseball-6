package baseball;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean check = true;
        while(check){
            // 정답 숫자 만들기
            List<Integer> computer = new ArrayList<>();
            while(computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1,9);
                if(!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while(check){
                System.out.print("숫자를 입력해주세요: ");
                String input = Console.readLine();
                if(input.length() != 3){
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                int[] result = {0, 0}; // 스트라이크, 볼
                for(int i=0;i<3;i++){
                    int num = input.charAt(i) - '0';
                    if(num == computer.get(i)){
                        result[0] += 1;
                    }else if(computer.contains(num)){
                        result[1] += 1;
                    }
                }

                if(result[0] == 0 && result[1] == 0 ){
                    System.out.println("낫싱");
                    continue;
                }
                if(result[1] != 0){
                    System.out.print(result[1] + "볼 ");
                }
                if(result[0] != 0){
                    System.out.print(result[0] + "스트라이크");
                    if(result[0] == 3){
                        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String endType = Console.readLine();
                        if(endType.charAt(0) - '0' == 1){
                            check = true;
                        }else{
                            check = false;
                        }
                        break;
                    }
                }
                System.out.print("\n");

            }

        }
    }
}
