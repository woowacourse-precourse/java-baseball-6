package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application ap = new Application();
        ap.start();
    }

    // 초기 화면
    private void start() {
        String input = null;
        do {
            // 게임 시작
            System.out.println("숫자 야구 게임을 시작합니다.");
            // 게임 함수로 이동
            play();
            // 재시작 or 종료
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
            if(!input.equals("1") && !input.equals("2")) throw new IllegalArgumentException(); // 에러 확인
        }while(!input.equals("2"));
    }

    // 야구 게임
    private void play() {
        while(true){
            List<Integer> randomNum = createRanNum();
            System.out.print("숫자를 입력해주세요 : ");
            String num = Console.readLine();

            // 숫자가 3자리가 아닌 경우
            if(num.length() > 3) throw new IllegalArgumentException();
            List<Integer> number = new ArrayList<>();
            // 같은 값을 입력하거나 숫자가 아닌 값을 입력한 경우
            try{
               Arrays.stream(num.split("")).forEach(i -> {
                   if (number.contains(Integer.parseInt(i))) throw new IllegalArgumentException();
                   else number.add(Integer.parseInt(i));
               });
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
            System.out.println(number);
            // 첫 번째 수 체크
            // 두 번째 수 체크
            // 세 번째 수 체크

            // 값이 맞다면
            return;

        }
    }

    private List<Integer> createRanNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
