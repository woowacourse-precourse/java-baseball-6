package controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private final List<Integer> randomNumbers;

    public RandomNumber() {
        this.randomNumbers = new ArrayList<>();
    }

    public List<Integer> getRandomNumbers() {
        System.out.println(randomNumbers.toString());
        return new ArrayList<>(randomNumbers);
    }

    public void generateNumbers(){
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public void clear(){
        randomNumbers.clear();
    }
}
