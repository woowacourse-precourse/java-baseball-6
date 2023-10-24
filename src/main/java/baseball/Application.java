package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        int[] arr1 = new int[computer.size()];
        for (int i = 0; i < computer.size(); i++)
            arr1[i] = computer.get(i).intValue();
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);
        System.out.println(Arrays.toString(arr1));


        String number1 = readLine();
        String number2 = readLine();
        String number3 = readLine();

        List<String> number = new ArrayList<>();
        number.add(number1);
        number.add(number2);
        number.add(number3);
        System.out.println(number);

        List<Integer> num = new ArrayList<>();
        for (String s : number) {
            num.add(Integer.parseInt(s));
        }
        System.out.println(num);

        int[] arr2 = new int[num.size()];
        for (int i = 0; i < num.size(); i++)
            arr2[i] = num.get(i).intValue();
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
        System.out.println(Arrays.toString(arr2));


        if (Arrays.equals(arr1, arr2)){
            System.out.println("동일");
        } else {
            System.out.println("성동일");
        }

        /*if (computer == num) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }*/
        //boolean isContainsNum = num.contains(computer);
        //System.out.println(isContainsNum);


    }
}
