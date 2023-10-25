## 기능구현목록
### 1. 플레이어가 숫자를 입력받는 기능
- void readInput(List<Integer> player);

### 2. 볼과 스트라이크 수를 계산하는 기능
- Result evaluate(List<Integer> player, List<Integer> computer)

### 3. 볼과 스트라이크 수를 출력하는 기능
- void printResult(Result result)

### 4. 결과값에 따라 게임을 종료시키는 기능
- boolean isStop(Result result, List<Integer> computer)

### 5. 예외를 처리하는 기능
- ExceptionHandler Class
  - void checkInputSize(String input, int size)
  - void checkNumber(int number, List<Integer> player)
  - void checkCommand(char command)