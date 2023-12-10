package model.service;

import model.domain.Discriminator;

import java.util.ArrayList;
import java.util.List;

public class DiscriminatorService {


    private int strikeNumber(String playerNum, List<Integer> computerNum){

        int strike = 0;

        for(int i=0; i<playerNum.length(); i++){

            int num = (int) playerNum.charAt(i) - 48;

            if(computerNum.contains(num) && computerNum.get(i) == num){

                strike++;
            }
        }

        return strike;
    }

    private int ballNumber(String playerNum, List<Integer> computerNum){

        int ball = 0;

        for(int i=0; i<playerNum.length(); i++){

            int num = (int) playerNum.charAt(i) - 48;

            if(computerNum.contains(num) && !(computerNum.get(i) == num)){

                ball++;
            }
        }

        return ball;
    }

    public List<Integer> discriminatorResult(String playerNum, List<Integer> computerNum){
        List<Integer> result = new ArrayList<>();
        int ball = ballNumber(playerNum, computerNum);
        int strike = strikeNumber(playerNum, computerNum);
        result.add(ball);
        result.add(strike);

        return result;
    }



}
