# 메세지
- 게임 도중 표시되는 메세지를 무엇으로 구현할 것인가?
- `enum` vs `interface`
- `enum`
  - enum을 class내부에 집어넣고, enum에 필드를 추가시킨다
  - 추가적인 로직 삽입에 유용
  - ```java
      public enum GameMessage {
        START("게임 시작"),
        END("게임 끝");

        private final String message;
    
        GameMessage(String message) {
            this.message = message;
        }
    
        public String getMessage() {
            return message;
        }
      }
    ```
- `interface`
  - 인터페이스에 메세지 변수를 선언한다
  - 단순, 상속에 의한 활용이 가능
  - ```java
    public interface Message {
      String START = "게임 시작";
      String END = "게임 끝";
    }
    ```
# exception 처리
- while(true) 내에서 exception이 throw되어도, 반복문을 나가는 조건에 해당되지않으면, 바깥쪽으로 예외가 전달되지 않아 정상 종료가 되지 않았습니다.
- 그래서 다음과 같이 try-catch문을 while문 외부에 배치시켰습니다.
```java
  public void trial(){
        try {
            //num의 각 숫자가 1부터 9까지 여야하고, 세자리여야한다. 이를 지키지 않으면 IllegalArgumentException이 발생해야한다
            while(true){
                System.out.println(INPUT);
                String origin = Console.readLine();
                validateInput(origin);
                Integer num = Integer.parseInt(origin);
                Integer ball = checkBall(num);
                Integer strike = checkStrike(num);


                //다 0이면
                if(ball>0 && strike==0) System.out.println(ball+BALL);
                else if(ball==0 && strike>0) System.out.println(strike+STRIKE);
                else if(ball>0 && strike>0) System.out.println(ball+BALL+" " + strike+STRIKE);
                else if(strike==3) {
                    System.out.println(END);
                    String choice = Console.readLine();
                    if(choice.equals("1")){
                        makeNumber();
                    }else if(choice.equals("2")){
                        return;
                    }else throw new IllegalArgumentException();
                }
                else System.out.println(NOTHING);

            }
        }catch(Exception e){//try-catch문이 있어야 예외가 잡히고 정상종료됨
            e.printStackTrace();
            //throw new IllegalArgumentException(); 새롭게 만들어서 던지지 말자  
             throw new IllegalArgumentException(e);
        }


    }
```
- 이렇게 되면, 예외발생시 반복문을 정상 종료시키고 나서 catch문으로 이동합니다.
- 또한 새롭게 예외를 생성해서 던지지 말아야한다. 그럼 기존 정보가 날아가기 때문이다.
- 기존 정보를 포함한 새로운 예외를 던지든지, 기존 예외를 그대로 던진다면, 해당 예외의 정보가 유실되지 않을 것이다.
- 하지만 위에처럼 하게 되면 예외가 두번있는것처럼 보인다. 또한 예외처리하는 catch블럭을 상위에서 못찾게되면 비정상종료가 된다.
- 정상 종료해야하기 때문에 로그만 출력하고 함수를 종료한다.
```java
  public void trial(){
        try {
            ...
            }
        }catch(Exception e){
            e.printStackTrace();//!!
        }
    }
```
