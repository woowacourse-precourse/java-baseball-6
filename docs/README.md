# 1주차 숫자 야구 구현 기능 목록

## 상대방(Computer)
1. 세 자리 숫자를 무작위로 정한다.
   1. List<Integer> computer = new ArrayList<>();에 세개의 숫자를 넣는다. pickNumberInRange()를 활용 
```text
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
          int randomNumber = Randoms.pickNumberInRange(1, 9);
          if (!computer.contains(randomNumber)) {
               computer.add(randomNumber);
           }
     }
```
2. user가 입력한 숫자와 비교한다. 
   1. 유저가 입력한 숫자의 자리와 computer의 자리 위치가 같은 지 확인하고 같으면 스트라이크 변수를 1증가시킨다.
   2. 위치가 같지 않다면 해당 숫자가 computer에 포함되는 지 확인하고 포함되면 볼 변수를 1증가시킨다.
   3. 1번과 2번 둘 다 아니라면 낫싱변수를 1증가시킨다.
   4. 전체 결과를 반환한다.
      1. 만약 스트라이크 변수가 3이면 ```3스트라이크
         3개의 숫자를 모두 맞히셨습니다! 게임 종료
         게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.``` 을 출력하고 게임종료을 한다.
         1. 이때 게임 재시작 / 종료 기능을 받는다. 재시작인 경우 1번으로 돌아가고 종료인 경우 애플리케이션을 종료한다. 단, System.exit()를 호출하지 않는다.
      2. 낫싱변수가 3인 경우 "낫싱"을 출력 한다.
      3. 스트라이크 변수의 값과 볼의 변수의 값을 출력하고 2번 처음으로 돌아간다.


## 유저(나)
1. 유저가 입력한 세 자리 숫자 역시 pickNumberInRange()를 활용한다.
2. 입력을 받을 때 Console의 readLine()을 활용한다.
3. 예외처리: 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다. 즉, 예외를 받아 애플리케이션을 종료하는 코드를 구현한다.