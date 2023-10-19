package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = randomNumber();

        while (true){

            String myball = getNumber();
            List<Integer> result = strikeZon(myball,computer);
            boolean threeOut = printGameResult(result);
            boolean regame = false;
            if (!threeOut){
                continue;
            }
            if (threeOut){
                regame = gameReStart(threeOut);
            }
            if (regame){
                computer = randomNumber();
                continue;
            }
            if (!regame){
                break;
            }
        }
    }

    //사용자로부터 숫자를 입력받는 메소드
    static String getNumber() {
        System.out.println("숫자를 입력해주세요 :");
        String myball= camp.nextstep.edu.missionutils.Console.readLine();
        numCheck(myball);
        return myball;
    }

    //입력받은 숫자가 정상적인 값인지 확인하는 함수
    static void numCheck(String myball){
        HashSet<Character>hashNum = new HashSet<>();
        for(char num : myball.toCharArray()){
            if(!hashNum.add(num) || !Character.isDigit(num)) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
        if(myball.length() !=3){
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
    static List<Integer> randomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    static List<Integer> strikeZon(String myball, List<Integer> computer){
        int pointer = 0;
        int strike = 0;
        int ball = 0;
        List<Integer> result = new ArrayList<>();
        for(char num : myball.toCharArray()){
            int value = Character.getNumericValue(num);
            if (value == computer.get(pointer)){
                strike++;
                pointer++;
                continue;
            }
            if (computer.contains(value)){
                ball++;
                pointer++;
                continue;
            }
        }
        result.add(ball);
        result.add(strike);
        return result;
    }
    static boolean printGameResult(List<Integer>result){
        if (result.get(1) == 3){
            System.out.println(result.get(1)+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (result.get(0) != 0 && result.get(1) != 0){
            System.out.println(result.get(0)+"볼 "+result.get(1)+"스트라이크");
            return false;
        }
        if (result.get(0) != 0 && result.get(1) == 0){
            System.out.println(result.get(0)+"볼");
            return false;
        }
        if (result.get(0) == 0 && result.get(1) != 0){
            System.out.println(result.get(1)+"스트라이크");
            return false;
        }
        if (result.get(0) == 0 && result.get(1) == 0){
            System.out.println("낫싱");
            return false;
        }

        return false;
    }
    static boolean gameReStart(boolean treeout){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String regame= camp.nextstep.edu.missionutils.Console.readLine();

        if(regame.equals("1")){
            return true;
        }
        if (regame.equals("2")){
            return false;
        }
        return false;
    }
}