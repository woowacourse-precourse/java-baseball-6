package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            List<Integer> computer = new ArrayList<>();
            List<Integer> human = new ArrayList<>();
            int strikes=0;
            int balls=0;
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while (true){
                strikes=0;
                balls=0;
                human.clear();
                System.out.print("숫자를 입력해주세요 : ");
                int num=sc.nextInt();

                int firstDigit = num / 100;
                int secondDigit = (num / 10) % 10;
                int thirdDigit = num % 10;

                if (num < 100 || num > 999) {
                    throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
                }else if (firstDigit == secondDigit || secondDigit == thirdDigit || firstDigit == thirdDigit) {
                    throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다.");
                }

                human.add(firstDigit);
                human.add(secondDigit);
                human.add(thirdDigit);


                for (int i = 0; i < 3; i++) {
                    if (computer.get(i).equals(human.get(i))) {
                        strikes++;
                    } else if (computer.contains(human.get(i))) {
                        balls++;
                    }
                }
                if (strikes == 0 && balls == 0) {
                    System.out.println("낫싱");
                } else {
                    String message = "";
                    if (balls > 0) {
                        message += balls + "볼 ";
                    }
                    if (strikes > 0) {
                        message += strikes + "스트라이크 ";
                    }
                    System.out.println(message);
                }
                if (strikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int game = sc.nextInt();
            if (game == 2) break;
        }
    }
}
