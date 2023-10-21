package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console
public class Application {
//    public void game() {
//        boolean RUNNING = true;
//        List<Integer> user = new ArrayList<>();
//        List<Integer> computer = new ArrayList<>();
//        System.out.println("숫자 야구 게임을 시작합니다.");
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//        while (RUNNING) {
//            //사용자 입력 :1~9 말고 다른 입력시 IllegalArgumentException 발생시키기
//            System.out.println("숫자를 입력해주세요 : ");
//            String input = readLine();
//                for (int i = 0; i < 3; i++) {
//                    user.add(Integer.valueOf(input.substring(i, i + 1)));
//                }
//            }
//    }

    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
            //볼: 숫자만
            //스트라익: 숫자, 자리 맞음
    }
}
