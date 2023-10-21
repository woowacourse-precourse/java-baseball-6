package baseball;

import baseball.domain.GameConstants;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //"게임 시작 문구" 출력　
        System.out.println("숫자 야구 게임을 시작합니다.");

        //공통 변수들 TODO : 추후 static class으로 뺄 수 있다.
        int n=3;
        int startN=1;
        int endN=9;
        String strikeText="스트라이크";
        String ballText="볼";
        String nothingText="낫싱";

        //컴퓨터는 서로 다른 숫자로 이루어진 3자리 숫자 1개를 뽑음　
        List<Integer> computerNumList = new ArrayList<>();
        while (computerNumList.size() < GameConstants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber);
            }
        }
        System.out.println("컴퓨터가 뽑은 수"+computerNumList);

        //사용자는 서로 다른 숫자로 이루어진 3자리 숫자 1개를 입력　
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();

        //사용자가 잘못된 값을 입력하면 IllegalArgumentException을 발생시킨 후 애플리케이션이 종료된다.
        //검증: 만약 숫자가 아닌 것을 입력하면 잘못 입력한 것이다.
        if (!isInteger(inputNum)) {
            throw new IllegalArgumentException();
        }

        //검증: 만약 숫자의 자리수가 3보다 작으면 잘못 입력한 것이다.
        //검증: 만약 숫자의 자리수가 3보다 크면 잘못 입력한 것이다.
        int inputNumLen = inputNum.length();
        if (inputNumLen<GameConstants.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (inputNumLen>GameConstants.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        //검증: 만약 같은 숫자가 2개 이상 있으면 잘못 입력한 것이다.
        Set numSet=new HashSet();
        for (int i=0; i<GameConstants.NUMBER_LENGTH; i++){
            numSet.add(inputNum.charAt(i));
        }
        if (numSet.size()<GameConstants.NUMBER_LENGTH){
            throw new IllegalArgumentException();
        }

        //검증이 완료되어야 변환 가능
        List<Integer> inputNumList = parseIntegerList(inputNum);
        System.out.println(inputNumList);

        //컴퓨터는 사용자가 입력한 숫자와 뽑은 숫자를 비교하여 힌트를 판단, 출력　
        //힌트는 스트라이크, 볼, 낫싱 3가지　
        //같은 수가 같은 자리에 있으면 스트라이크　
        int strike = 0;
        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++){
            if (inputNumList.get(i).equals(computerNumList.get(i))) {
                strike++;
            }
        }

        //같은 수가 다른 자리에 있으면 볼　
        int ball = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++){
            for (int j = 0; j < GameConstants.NUMBER_LENGTH; j++){
                if (inputNumList.get(i).equals(computerNumList.get(j))) {
                    ball++;
                }
            }
        }

        //같은 수가 전혀 없으면 낫싱　
        boolean nothing = false;
        if (strike==0 && ball==0) nothing=true;

    }

    //string이 Integer인지 아닌지 판단. TODO: IntegerUtil에 넣기
    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    //String to List<Integer> TODO: IntegerListConverter 따로 둬서 IntegerListConverter.parseIntegerList
    public static List<Integer> parseIntegerList(String string){
        List<Integer> integerList = new ArrayList<>();

        for (char character : string.toCharArray()){
            integerList.add(parseInteger(character));
        }

        return integerList;
    }

    //char to Integer TODO: IntegerUtil에 넣기
    public static Integer parseInteger(char character){
        Integer integer = character - '0';

        return integer;
    }


    //같은 수가 같은 자리에 있으면 스트라이크　


}
