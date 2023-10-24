package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> randomnumber = new ArrayList<>();
        List<Integer> inputnumber = new ArrayList<>();
        int[] count = new int[2]; // 첫번째는 스트라이크 카운트, 두번째는 볼카운트
        int quit = 0;

        randomnumber = makecomputernumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(quit != 2){
            System.out.printf("숫자를 입력해주세요 : ");
            inputnumber = saveinput(Integer.parseInt(Console.readLine()));
            count = judgecount(inputnumber, randomnumber);
            quit = printcount(count);
            if(quit == 1){
                randomnumber = makecomputernumber();
            }
            else if(quit == 2){
                quit = 2;
            }
        }
        return;
    }
    public static List<Integer> makecomputernumber(){
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> numbers = new ArrayList<>();
        int i = 0;
        while(set.size()<3){
            set.add(Randoms.pickNumberInRange(1,9));
        }
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()){
            numbers.add(iter.next());
        }
        return numbers;
    }

    public static List<Integer> saveinput(int input){
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        List<Integer> inputnumber = new ArrayList<>();
        if(input< 100 || input >999){
            throw new IllegalArgumentException();
        }
        set.add(input/100);
        set.add(input/10%10);
        set.add(input%10);
        if(set.size() != 3){
            throw new IllegalArgumentException();
        }
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()){
            inputnumber.add(iter.next());
        }
        return inputnumber;
    }
    public static int[] judgecount(List<Integer> input, List<Integer> computer){
        int[] count = {0, 0}; // 첫번째는 스트라이크 카운트, 두번째는 볼카운트
        for(int i=0; i<3;i++){
            if(input.get(i) == computer.get(i)){
                count[0] ++;
            }
            else if(computer.contains(input.get(i))){
                count[1] ++;
            }
        }
        return count;
    }

    public static int printcount(int[] count){
        if(count[0] == 3){
            int input;
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Integer.parseInt(Console.readLine());
            if (input == 1){
                return 1;
            }
            else if(input == 2){
                return 2;
            }
        }
        else if(count[0]>0 && count[1] == 0){
            System.out.printf("%d스트라이크\n", count[0]);
        }
        else if(count[0] == 0 && count[1] > 0){
            System.out.printf("%d볼\n", count[1]);
        }
        else if(count[0] > 0 && count[1] > 0){
            System.out.printf("%d볼 %d스트라이크\n", count[1], count[0]);
        }
        else if(count[0] == 0 && count[1]  == 0){
            System.out.printf("낫싱\n");
        }
        return 0;
    }
}
