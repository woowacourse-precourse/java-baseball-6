package baseball.domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

import baseball.utils.EqualUtil;

public class Player {

    public static ArrayList<Integer> inputData(int digits){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> USER_NUM_LIST = new ArrayList<>();
        int userNum;

        while(true){
            try{
                userNum = input.nextInt();

                USER_NUM_LIST.clear();
                USER_NUM_LIST.addAll(EqualUtil.equalSingleNumber(userNum));

                if(USER_NUM_LIST.size()!=digits){
                    System.out.println("중복되지 않는 3자리 수를 입력하세요.");
                    continue;
                }

                if(USER_NUM_LIST.contains(0)){
                    System.out.println("1~9 범위의 수만 입력하세요.");
                    continue;
                }
                break;
            }catch(InputMismatchException e){
                System.out.println("숫자만 입력하세요.");
                input.nextLine();
            }
        }

        System.out.println(USER_NUM_LIST);
        return USER_NUM_LIST;
    }
}
