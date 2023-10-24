package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    public String isStrike(String guessNumber, String answerNumber) {
        int count =0;
        for (int i = 0; i < guessNumber.length(); i++) {
            if(guessNumber.charAt(i) == answerNumber.charAt(i)){
                count++;
            }
        }
        return count + "스트라이크";
    }

    public String isBall(String guessNumber, String answerNumber){
        int count =0;
        for (int i = 0; i < guessNumber.length(); i++) {
            count = isPresentOtherDigit(guessNumber, answerNumber, i)? count+1 : count;
        }
        return count + "볼";
    }

    public String isNothing(String result){
        return (result.isEmpty()) ? "낫싱": result;
    }

    public static boolean isPresentOtherDigit(String guessNumber, String answerNumber, int i) {
        for(int j = 0; j< answerNumber.length(); j++){
            if(i == j){
                continue;
            }
            if(guessNumber.charAt(i) == answerNumber.charAt(j)){
                return true;
            }
        }
        return false;
    }
    @Test
    void generateRandomNumber_3자리수_조건에_맞는지확인(){

        Assertions.assertDoesNotThrow(()->{
            Computer computer = new Computer();
        });
        Assertions.assertDoesNotThrow(()->{
            Computer computer = new Computer();
        });
        Assertions.assertDoesNotThrow(()->{
            Computer computer = new Computer();
        });
    }
    @Test
    void Count가_볼_스트라이크_낫싱_인지확인1(){
        Computer computer = new Computer(Count.provideCount("143"));
        Count count = Count.provideCount("135");
        Assertions.assertEquals(computer.judgeGameResult(count), "1볼 1스트라이크" );



    }
    void Count가_볼_스트라이크_낫싱_인지확인2(){
        Computer computer = new Computer(Count.provideCount("243"));
        Count count = Count.provideCount("241");
        Assertions.assertEquals(computer.judgeGameResult(count), "2스트라이크" );



    }

    @Test
    void 볼_확인(){
        Count count1 = Count.provideCount("123");
        Count count2 = Count.provideCount("451");
        Assertions.assertEquals(isBall(count1.toString(),count2.toString()), "1볼");
    }

    @Test
    void 스트라이크_확인(){
        Count count1= Count.provideCount("123");
        Count count2 = Count.provideCount("123");
        Assertions.assertEquals(isStrike(count1.toString(), count2.toString()), "3스트라이크");

        Count count3= Count.provideCount("527");
        Count count4 = Count.provideCount("517");
        Assertions.assertEquals(isStrike(count3.toString(), count4.toString()), "2스트라이크");

    }


    @Test
    void 낫싱_확인(){
        Assertions.assertEquals(isNothing(""), "낫싱");
        Assertions.assertEquals(isNothing("1스트라이크"),"1스트라이크");

    }



}
