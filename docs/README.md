# 기능 요구 사항

### 1. 힌트 기능 구현
- 1-1. 스트라이크인 경우 
  - 같은 자리에 같은 수가 있는 경우
- 1-2. 볼인 경우
  - 다른 자리에 사용자가 입력한 값과 같은 수가 있는 경우
- 1-3. 낫싱인 경우
  - 3개의 숫자 모두 같은 수가 전혀 없는 경우

### 2. 컴퓨터가 임의의 수 3개를 선택하는 기능 구현
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  - 사용 예시  
      ```List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
    computer.add(randomNumber);
    }
    } 
    ```
### 3. 사용자가 3개의 숫자를 맞출때까지 입력한 숫자에 대한 결과 출력하는 기능 구현(입출력 기능)
- 3개의 숫자를 모두 맞추지 못한 경우라면 계속해서 사용자 입력을 받는다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 3개의 숫자를 모두 맞춘 경우라면 게임을 종료한다.
  - 이때 게임이 끝난 경우 재시작/종료를 구분하는 기능을 구현한다.(1-재시작/2-종료)

### 4. 사용자가 잘못된 값을 입력한 경우 예외 발생 기능 구현
- 사용자가 잘못된 값을 입력한 경우라면 `IllegalArgumentException` 발생 후 애플리케이션 종료
  - 사용자는 서로 다른 3자리의 수를 입력해야 한다. ex) 456, 789, 187
  - 이때 애플리케이션 종료는 System.exit()를 사용하지 않고 진행해야 한다. try catch return으로 진행할 것
  