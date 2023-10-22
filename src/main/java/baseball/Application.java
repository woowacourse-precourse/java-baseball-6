package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }


        System.out.println(computer);

        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        try{
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            int number = scanner.nextInt();

            if(number<=0 || number > 999 || !IsDifferentDigits(number)){
                throw new IllegalAccessException();
            }
            System.out.println(number);
            // TODO number -> List로 변환
            // TODO ball,Strike,nothing 체크
            // TODO 3Strike일때 게임종료
            // TODO 게임종료후 게임 다시 시작 or 완전히 종료

        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (java.util.InputMismatchException exception){
        } finally {
            scanner.close();
        }

    }

    public static boolean IsDifferentDigits(int number){ // 다 다르면 true
        boolean flag = false;
        Set<Integer> set = NumbersToSet(number);
        if (set.size() == String.valueOf(number).length()) {
            flag = true;
        }
        return flag;
    }

    public static List<Integer> NumbersToList(int number){
        List<Integer> list = new ArrayList<>();
        for(int i =0; i< String.valueOf(number).length(); i++){
            list.add((int) String.valueOf(number).charAt(i));
        }
        return list;
    }
    
    public static Set<Integer> NumbersToSet(int number){ 
        Set<Integer> set = new HashSet<>();
        for(int i =0; i< String.valueOf(number).length(); i++){
            set.add((int) String.valueOf(number).charAt(i));
        }
        return set;
    }
    
    public static Set<Integer> ListToSet(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        for(int i =0; i< list.size(); i++){
            set.add(list.get(i));
        }
        return set;
    }

    public static Integer HowManySameNumbers(int number){
        List<Integer> listNumber = NumbersToList(number);
        
        
        
        return null;
    }


}
