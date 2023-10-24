package baseball.view;

public class Output{
    void resultPrint(int ballCount, int strikeCount) {
        if(strikeCount==3){
            System.out.println(Speak.gameEndSpeak);
        }
        else if(strikeCount!=0 && ballCount!=0){
            System.out.println(ballCount+Speak.ballSpeak+" "+ strikeCount+Speak.strikeSpeak);
        }
        else if(strikeCount==0){
            System.out.println(ballCount+Speak.ballSpeak);
        }
        else if(ballCount == 0){
            System.out.println(strikeCount+Speak.strikeSpeak);
        }
        else{
            System.out.println(Speak.notThingSpeak);
        }
    }
}