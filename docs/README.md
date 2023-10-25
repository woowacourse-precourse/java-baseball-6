### 컴퓨터 객체가 필요한 서비스(class ComputerService)
boolean isNotDuplicatedNum()
생성한 숫자가 중복인지 검사
### 컴퓨터 역할(clas Computer)
- 의존  
ComputerService computerService

- 메소드  
List<Integer> selectNumbers()  
중복 없이 랜덤한 수 3개 생성 

### 유저 서비스(class UserService)

- 메소드  
boolean isInputRight (List<Integer> numbers)  
유저가 제대로 된 입력을 했는지 검사

### 유저 역할(class User)
- 의존  
UserService userService

- 메소드  
inputNumbers() throws IllegalArgumentException   
세개의 숫자 입력 받기


### 게임을 진행하는 역할(class GamePlayer)
- 의존  
Computer computer  
User user

- 메소드  
Map<String,Integer> oneTurn(List<Integer> computerSelect)  
유저가 숫자를 예측하고, 컴퓨터와 비교 후 상태 return  
void printScore(Map<String,Integer> score)  
유저의 상태를 출력  
void oneGame()
한 게임의 진행과 종료  
void playGame()  
전체 게임 진행
