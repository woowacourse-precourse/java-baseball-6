package baseball;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static boolean isInt(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static boolean duplicateCheck(String str){
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i) == str.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
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

                // 예외 처리
                if(!isInt(input)){ // 입력이 숫자가 아닌 경우
                    throw new IllegalArgumentException("입력은 숫자여야 합니다.");
                }
                if(input.length() != 3){ // 입력이 3자리가 아닌 경우
                    throw new IllegalArgumentException("입력은 3자리의 숫자여야 합니다.");
                }
                if(duplicateCheck(input)){ // 입력이 서로 다른 수가 아닌 경우
                    throw new IllegalArgumentException("입력은 서로 다른 숫자여야 합니다.");
                }


                // 스트라이크, 볼, 낫싱 체크
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
                        String endStr = Console.readLine();
                        int endNum = endStr.charAt(0) - '0';
                        if(endNum == 1){
                            check = true;
                        }else if(endNum == 2){
                            check = false;
                        }else{
                            throw new IllegalArgumentException("입력은 1 또는 2여야 합니다.");
                        }
                        break;
                    }
                }
                System.out.print("\n");

            }

        }
    }

}
