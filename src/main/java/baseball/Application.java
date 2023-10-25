package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static class GenerateRandomNum {
        public int randomMake(){
            Random random = new Random();
            return random.nextInt(9) + 1;
        }

        public List<Integer> create(){
            List<Integer> computerNumber = new ArrayList<>();
            while (computerNumber.size() < 3){
                int randomNumber = randomMake();
                if(computerNumber.contains(randomNumber)){
                    continue;
                }else {
                    computerNumber.add(randomNumber);
                }
            }
            return computerNumber;
        }
    }
}
