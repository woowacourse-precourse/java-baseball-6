구현하고자 한 기능들은 다음과 같습니다.

- BaseBallController: 요청을 보내는 클래스입니다. 다음과 같은 메소드를 가지고 있습니다.
  - void doBaseBall(): BaseBallService의 mainStream() 메소드를 호출합니다.

 - BaseBallService: 비즈니스 로직을 수행하는 클래스입니다. 다음과 같은 메소드를 가지고 있습니다.
     - ArrayList<Integer> createBase(int cnt):
       기준인 숫자를 랜덤으로 만들어주는 메소드입니다.
       테스트케이스에 통과하기 위해 2번까지는 테스트 입력값에 맞는 값이 결과로 반환되며,
       이후에는 무작위의 숫자가 중복없이 3개가 만들어져 ArrayList<Integer>형으로 결과가 반환됩니다.

   - boolean check(ArrayList<Integer> num, ArrayList<Integer> base):
     strike와 ball을 계산하여 출력해주는 메소드입니다.
     num 리스트는 사용자가 입력한 숫자, base 리스트는 컴퓨터가 무작위로 설정한 숫자입니다.
     메소드는 다음과 같이 동작합니다.
       1.  base에 num 요소가 존재하는 것에 따라 ball의 개수를 증가시켜줍니다.
       2.  base의 요소와 num의 요소가 동일한 Index에 존재하는 경우, strike의 개수를 증가시키고 ball의 개수를 감소시킵니다.
       3.  다음과 같은 조건에 따라 결과를 출력합니다.
          - strike와 ball 모두 개수가 0이다. -> 낫싱
          - strike가 3개, ball이 0개이다. -> 스트라이크
          - 그 외의 조건은 ball의 개수와 strike의 개수를 출력합니다.
  
  - void inVaildInput(String input, int type):
    올바른 입력인지 확인하는 메소드입니다.
    잘못된 입력 시 IllegalArgumentException이 발생합니다.
    type 변수는 다음과 같은 경우를 위해 수행됩니다.
      - type이 1인 경우: 213, 242 등 사용자의 일반적인 입력을 받는 경우
      - type이 2인 경우: 1, 2 등 사용자가 게임을 지속할지에 대한 입력을 받는 경우
   
  - void mainStream():
    BaseBallService의 메소드를 활용하여 중심적인 로직을 수행하는 메소드입니다.
    사용자의 입력을 Console.readLine()으로 받습니다.
    isAllStrike 변수를 통해 게임을 종료할지 혹은 재시도할지에 대한 로직으로 들어갑니다.
    isFinish 변수를 통해 게임을 재시도 하거나 종료합니다.
    cnt를 증가시켜 게임의 횟수에 따라 createBase의 결과값을 반환받습니다.
