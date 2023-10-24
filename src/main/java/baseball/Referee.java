package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Referee {
    public int[] judgecount(List<Integer> input, List<Integer> computer){
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

    public int printcount(int[] count){
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
