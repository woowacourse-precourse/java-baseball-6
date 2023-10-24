# 구현할 기능 목록
  
### 1. 게임 시작  
- `while(isGameRestarting)` loop를 사용하여 게임 재시작 여부를 검사하고 반복  
  
### 2. 컴퓨터 숫자(랜덤값) 생성  
- `generateComputerNum`: 메서드를 사용하여 1~9 중 중복되지 않는 3개의 숫자를 생성  
  - type: List<Integer>  
  
### 3. 게임 진행  
- `while(isRoundRunning)` loop를 사용하여 게임 진행 여부를 검사하고 반복  
- `Console.readLine()`: 사용자에게 숫자 입력을 받음  
- `validateInput`: 사용자 입력값의 유효성을 검사  
  - 1~9의 3자리 숫자로 구성되어 있는지  
  - 유효한 값이 아닐 경우 게임을 종료함  
  - type: boolean  
- `parseUserInput`: 사용자 입력값을 int 배열로 반환  
  - type: int[]  
- `calculateNum`: 컴퓨터가 생성한 숫자와 사용자가 입력한 숫자를 비교  
  - 볼, 스트라이크 개수 확인  
  - 게임 종료 조건 확인 (3스트라이크 => `isRoundRunning = false`)  
  - type: boolean  
- 게임이 종료되면, 사용자에게 게임 재시작 여부를 입력받음  
  - 1 입력: 게임 재시작 (`isGameRestarting = true`)  
  - 2 입력: 게임 종료 (`isGameRestarting = false`)  
  
### 4. 예외 처리  
사용자가 잘못됨 값을 입력할 경우, `IllegalArgumentException`을 발생시킴  
- 사용자가 입력한 값이 1~9의 3자리 숫자로 구성되어 있지 않은 경우  
- 게임 재시작 여부 입력값이 1이나 2가 아닐 경우  