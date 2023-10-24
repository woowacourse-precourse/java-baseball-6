package baseball.controller;

import baseball.computer.Computer;
import baseball.user.User;

import java.util.List;

public class Controller {

    public Computer makeComputerNumber(){
        Computer computer = new Computer(); // 컴퓨터 값 생성
        return computer;
    }

    public User makeUserNumber(){
        User user = new User(); // 유저 값 생성
        return user;
    }

    public String equals(List<Integer> computer, List<Integer> user){
        String ball = "";
        int ballNumber = 0;
        String strike = "";
        int strikeNumber = 0;
        String nothing = "";

        for(int i = 0 ; i< computer.size(); i++){
            if(computer.contains(user.get(i))){
                //포함되어 있는지 확인하고 equals로 위치까지확인
                if(computer.get(i).equals(user.get(i))){
                    //위치까지 확인해서 동일한 위치이다면
                    strikeNumber++;
                    strike = "스트라이크";
                }else{
                    ballNumber++;
                    ball = "볼";
                }
            }
            else if(!computer.contains(user.get(0)) && !computer.contains(user.get(1)) && !computer.contains(user.get(2))){
                nothing = "낫싱";
            }
        }

        if(ballNumber != 0){
            ball = ballNumber + ball;
        }
        else{
            ball= "";
        }


        if(strikeNumber != 0 && ballNumber != 0){
            strike = " " + strikeNumber + strike;
        }
        else if(strikeNumber != 0){
            strike = strikeNumber + strike;
        }else{
            strike = "";
        }
        String result = ball + strike + nothing;
        System.out.println(result);

        return result;
    }


}