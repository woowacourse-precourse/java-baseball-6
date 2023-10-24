package baseball;
import java.util.*;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.pool.TypePool;

public class Application {

    public static int isStrike(List<Integer> computer, int[] user) {
        int sCount=0;
        for (int i=0; i<3; i++) {
            if (computer.get(i) == user[i])
                sCount++;
        }
        return sCount;
    }


    public static int isBall(List<Integer> computer, int[] user) {
        int bCount=0;
        for ( int i=0; i< computer.size(); i++) {
            for (int j=0; j<user.length; j++) {
                if(i != j) {
                    if (computer.get(i) == user[j])
                        bCount++;
                }
            }
        }
        return bCount;
    }

    public boolean isOut(List<Integer> computer, int[] user) {
        int sCount = isStrike(computer, user);
        int bCount = isBall(computer, user);

        if(bCount>0) System.out.print(bCount + "볼 ");
        if(sCount>0) System.out.print(sCount + "스트라이크");
        if(bCount==0 && sCount==0) System.out.print("낫싱");
        System.out.println();

        if(sCount == 3) return true; else return false;
    }

    public static boolean isUniqueDigits(int number) {
        if (number < 100 || number > 999) {
            return false;

        }
        int digit1 = number / 100;
        int digit2 = (number / 10) % 10;
        int digit3 = number % 10;

        if (digit1 == digit2 || digit1 == digit3 || digit2 == digit3) {
            return false;
        }
        if (digit1 < 1 || digit1 > 9 || digit2 < 1 || digit2 > 9 || digit3 < 1 || digit3 > 9) {
            return false;
        }
        return true;
    }

    public static void chkInput(int n) throws IllegalArgumentException{
        if(isUniqueDigits(n)==false)
            throw new IllegalArgumentException("입력값 오류");
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application T = new Application();
        Scanner kb = new Scanner(System.in);
        while(true) {
            boolean gameover = false;
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            for (int n : computer)
                System.out.println(n);

            System.out.println("숫자 야구 게임을 시작합니다.");

            while(!gameover) {
                System.out.print("숫자를 입력해주세요 : ");
                String user_in = Console.readLine();
                int t_in = Integer.parseInt(user_in);

                try {
                    chkInput(t_in);
                }catch(IllegalArgumentException e) {
                    System.err.println(e.toString());
                    throw e;
                }

//                if(isUniqueDigits(t_in)==false) throw new IllegalArgumentException("입력데이터 형식이 틀렸습니다.");

//                System.out.println(user_in);

                int[] user = Stream.of(String.valueOf(t_in).split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (T.isOut(computer, user)) gameover=true;
            }
            if(gameover) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String go_stop = Console.readLine();
                if (go_stop.equals("2")) break;
                else continue;
            }
        }
    }
}
