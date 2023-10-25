1. 랜덤으로 숫자를 뽑아내는 과정
   >camp.nextstep.edu.missionutils.Randoms의 Randoms를 사용하여
   > 예시로 보여주신 과정을 토대로 랜덤인 3개의 숫자를 뽑아낼 수 있게 하였습니다.
---
2. 유저의 숫자를 입력받는 과정
   >`camp.nextstep.edu.missionutils.Console`의 readline함수를 활용해서
   > 유저로부터 입력을 받고 이를 String 변수에 저장을 합니다.
    ```java
   line=Console.readLine();
   ```
   
---    
3. 유저의 숫자 타당성 확인
    > 유저의 입력이 3자리 숫자인지 확인합니다. 만약 그렇지 않은 경우 예외
처리를 해줍니다.
    <br>

    이에 대해서는 유저의 입력을 저장한 String을 새로 작성한 `isValidInput`함수의 인자
로 넣어줍니다. 그리고 해당 입력에서 `3자리 숫자인지` `0을 입력받지는 않았는지` `중복되는 숫자가 없는지`
를 확인해서 boolean 형태로 return을 해주게 되고 만약 `false`인 경우에 `throw new IllegalArgumentException("잘못된 입력입니다.");`
를 통해서 예외 처리를 진행하였습니다.
    ```java
    throw new IllegalArgumentException("잘못된 입력입니다.");
    ```
---
4. 게임 진행 순서
    <br>
   이 과정에서는 크게 큰 while을 기준으로 전체 게임의 종료 여부와
   <br>
    하나의 게임의 승패 여부를 구분할 수 있게 하였습니다.

    ```java
    while(게임 종료 여부){
        while(게임 승리 여부 --> strike가 3개인지){
        }        
    }
   ```
   위의 과정을 토대로 진행하였습니다.
---
5. 비교
   >유저의 input과 컴퓨터의 결과의 비교는 완전탐색을 통해서 진행하였습니다.
    - 유저의 숫자와 컴퓨터의 숫자가 일치&&자리수도 일치 --> strike++
    - 유저의 숫자와 컴퓨터의 숫자만 일치 --> ball++
   ```java
    for (int i = 0; i < 3; i++) {
        char digitChar = line.charAt(i);
        int digit = Character.getNumericValue(digitChar);
        for (int j = 0; j < 3; j++) {
            if (digit == computer.get(j)) {
                if (i == j) {//숫자와 자릿수가 모두 같으면 strike
                    strike++;
                } else {//숫자만 같은 경우 ball
                    ball++;
                }
            }
        }
    }
    ```
---
6. 출력
    >있는 그대로 결과 변수인 strike, ball을 출력해주었습니다.
    만약 두 수의 합이 0인 경우에는 낫싱을 출력합니다.
    ```java
   if (ball + strike == 0) {
        System.out.println("낫싱");
    } else {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
   ```
---
7. 진행 or 종료
   > 게임이 종료된 이후 유저의 입력을 받아서 1을 입력 받는 경우에는
   > 더 진행될 수 있도록 `while`을 빠져나가지 못하고 만약 2를 입력시에는
   > 변수 조정을 통해서 종료될 수 있도록 하였습니다.
    ```java
    if(restart.equals("1")){
        System.out.println("restart");
    }
    else{
        System.out.println("finish");
        keep_going=false;
    }
    ```