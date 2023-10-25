package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean playGame(){
        int[] randomNumber = RandomNumber();
        while(true){
            int[] playerInput = playerInput();
            int[] score = checkScore(randomNumber, playerInput);

            if(score[0]!=0 && score[1]!= 0) {
                System.out.println(score[0] + "볼 " + score[1] + "스트라이크");
            }else if(score[0] == 0  && score[1] != 0){
                System.out.println(score[1] + "스트라이크");
            }else if(score[0] != 0 && score[1] == 0) {
                System.out.println(score[0] + "볼");
            }else{
                System.out.println("낫싱");
            }

            if (score[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
    }

    public int[] checkScore(int[] randomNumber, int[] playerInput){
        int[] score = new int[2];
        for (int i = 0 ; i < randomNumber.length ; i++){
            for(int j = 0 ; j < randomNumber.length ; j++){
                if(i == j && randomNumber[i] == playerInput[j]){
                    score[1]++;
                }else if(randomNumber[i] == playerInput[j]){
                    score[0]++;
                }
            }
        }
        return score;
    }

    public int[] RandomNumber(){
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size()<3){
            numbers.add(Randoms.pickNumberInRange(1,9));
        }
        int[] array = numbers.stream().mapToInt(i->i).toArray();
        return array;
    }

    public int[] playerInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        String[] inputs = input.split("");

        if (inputs.length != 3) {
            throw new IllegalArgumentException("3자리를 입력하지 않았습니다.");
        }
        if(Objects.equals(inputs[0], inputs[1]) || Objects.equals(inputs[0], inputs[2])){
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }
        if(Objects.equals(inputs[1],inputs[2])){
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }

        int[] numbers = new int[3];

        for (int i = 0; i < inputs.length; i++){
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        return numbers;
    }

    public boolean keepGo(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String input = Console.readLine();
        if(!Objects.equals(input, "1") && !Objects.equals(input, "2")){
            throw new IllegalArgumentException("1 혹은 2를 입력하지 않았습니다.");
        }
        if (Objects.equals(input, "2")){
            System.out.println("게임 종료");
            return false;
        }else{
            return true;
        }
    }
}
