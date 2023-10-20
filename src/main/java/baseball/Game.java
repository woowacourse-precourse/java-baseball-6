package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {

    List<Integer> computerNumbers;
    public Game(){
        computerNumbers = getComputerNumbers();
//        System.out.println("컴퓨터 랜덤숫자: " + computerNumbers);
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameStart() {

        int strikes = 0;
        int balls = 0;

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        System.out.println(userInput);
        List<Integer> inputNumbers = getVerifiedNumbers(userInput);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (inputNumbers.get(i).equals(computerNumbers.get(i))){
                    strikes++;
                    break;
                }
                if (inputNumbers.get(i).equals(computerNumbers.get(j))){
                    balls++;
                    break;
                }
            }
        }

        if (strikes == 3){
            System.out.printf("%d스트라이크\n", strikes);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            replayOrExit();
        } else if (strikes == 0 && balls == 0){
            System.out.println("낫싱");
            replay();
        } else if (balls == 0){
            System.out.printf("%d스트라이크\n", strikes);
            replay();
        } else if (strikes == 0){
            System.out.printf("%d볼\n", balls);
            replay();
        } else {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
            replay();
        }
    }

    public void replayOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String choice = Console.readLine();
        if (choice.equals("1")){
            Game game = new Game();
            game.gameStart();
        } else if (choice.equals("2")){
            System.out.println("게임 종료");
        } else {
            throw new IllegalArgumentException("잘못된 숫자를 입력하였습니다.");
        }
    }

    public void replay(){
        gameStart();
    }

    private List<Integer> getComputerNumbers(){

        List<Integer> computer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            computer.add(Randoms.pickNumberInRange(1, 9));
        }
        validateNumbers(computer);

        return computer;
    }

    private List<Integer> getVerifiedNumbers(String inputValue){

        // Null 체크
        if (inputValue.isEmpty()){
            throw new IllegalArgumentException("입력된 숫자가 없습니다.");
        }

        // 3자리 입력 여부
        if (inputValue.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }

        // 숫자 입력 여부
        for (int i = 0; i < inputValue.length(); i++){
            char numberCheck = inputValue.charAt(i);
            if (numberCheck < 49 || numberCheck > 57){
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력해주세요.");
            }
        }

        List<Integer> verifiedNumbers = stringToInteger(inputValue);

        // 숫자 중복 여부
        validateNumbers(verifiedNumbers);

        return verifiedNumbers;
    }

    private void validateNumbers(List<Integer> numbers){

        // 중복값 찾기
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()){
            System.out.println("중복된 숫자가 있습니다.");
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private List<Integer> stringToInteger (String inputValue){
        List<Integer> toInteger = new ArrayList<>();
        String[] inputValueArr = inputValue.split(""); // 문자열 분리 후 배열에 삽입

        for (int i = 0; i < inputValue.length(); i++){
            toInteger.add(Integer.valueOf(inputValueArr[i]));
        }

        return toInteger;
    }
}