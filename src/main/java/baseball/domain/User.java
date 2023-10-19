package baseball.domain;

public class User{
    private final String numbers;
    private Point point;

    public User(String numbers){
        this.numbers=numbers;
        this.point=new Point(0,0);
    }

    public void compareAndRefresh(String numbers){
        int[] result={0,0,0};

        for(String number: split(numbers)){
            addResult(result,compareEach(number,number.indexOf(number)));
        }

        refreshPoint(result);
    }

    private int compareEach(String number,int index){
        if(isSamePlace(number,index)){
            return 0;
        }

        if(isExistNumber(number)){
            return 1;
        }

        return 2;
    }

    private String[] split(String numbers){
        return numbers.split("");
    }

    private void addResult(int[] result,int resultIndex){
        result[resultIndex]+=1;
    }

    private boolean isSamePlace(String number,int index){
        return this.numbers.indexOf(number)==index;
    }

    private boolean isExistNumber(String number){
        return this.numbers.contains(number);
    }

    private void refreshPoint(int[] result){
        this.point=new Point(result[0],result[1]);
    }

    public boolean equalsPoint(Point comparePoint){
        return point.equals(comparePoint);
    }

    public boolean isThreeStrike() {
        return this.point.equalsStrike(3);
    }

}
