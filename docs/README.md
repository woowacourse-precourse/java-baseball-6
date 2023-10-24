

## 주요 구현 기능
1. 게임을 플레이할 playGame메서드를 구현한다.
2. 유저에게 번호를 입력받을 inputUserNumber메서드 기능을 구현한다.
3. 사용자의 입력값이 잘못된 값이 아닌지 체크할 checkUserInput메서드 기능을 구현한다.
4. 컴퓨터에게 랜덤한 값을 입력받을 getRandomNumber메서드 기능을 구현한다.
5. 유저넘버와 컴퓨터 넘버를 비교할 compareNumber 메서드 기능을 구현한다.
6. 결과를 체크할 checkResult메서드 기능을 구현한다.
7. 게임 재시작 체크를 위한 replayInputCheck 메서드 기능을 구현한다.

### 리팩토링
#### 1차 기능구현 이후
* 볼과 스트라이크를 저장하는 int[] result 변수가 주석이 없다면 무슨기능을 하는지 한 번에 알아보기힘듬 클래스로 분리하여 객체로 분리 필요
* 평소 알고리즘을 풀던대로 절차지향적인 코드를 작성하다보니 객체지향 언어인 자바의 장점을 살리지 못함 기능별로 클래스 분리 필요
    * mvc 패턴을 만족하려 노력해보기
    * model - ball과 strike의 변수를 가지는 Result 클래스 생성하기
    * view - 결과와 게임플레이 message를 출력하는 Message 클래스 생성하기
    * controller - 게임 동작을 담당하는 User, Computer, Baseball 클래스 구현하기 
#### 1차 리팩토링
* Computer 클래스 util 로 이동 model과 view에 전혀 접점이 없음
  * mvc패턴에 대하여 자세히 공부하기 
* 메서드가 한가지의 역할만 하게 노력 필요
* 메서드명 좀더 명확하게 작성 필요
* 접근제어자와 static 에 대해 공부하기
#### 2차 리팩토링 
* User 클래스의 메서드를 보면 사용자 입력만 받는게 아닌 입력값 체크 까지 같이 하고있음 한가지의 역할만 하게 분리 필요
* Message Import 부분 수정 필요
#### 3차 리팩토링
* resultMessage 부분 3스트라이크 출력문 삭제 가능 마지막 스트라이크 출력문이 출력

# 최종 주요 기능
## 컴퓨터
* getRandomNumber
   * 컴퓨터의 랜덤번호를 가져온다.
## 입력받기
* User
   * getUserNumber
      * user의 입력값을 받아 checkUserInput 메서드를 통해 이상이 없을시 userNumber 입력 문자열을 리턴한다.
   * inputReplay
      * 게임 종료 후 게임 재시작에대한 입력값을 받는다.
      * checkInputReplay를 통해 입력문에 이상이 없는지 확인후 게임 재시작에 관한 boolean 을 리턴한다.
### 예외처리
* User
   * checkUserInput
      * 유저가 입력한 값이 1~9 사이의 숫자가 맞는지 확인한다.
      * 유저가 입력한 값이 3자리 수를 넘지 않는지 확인한다.
      * 유저가 입력한 값이 숫자가 아닌 문자가 들어오지 않는지 확인한다.
      * 중복된 값이 들어오지 않는지 확인한다. (HashSet활용)
      * 조건을 충족하지 못할시 오류
   * checkInputReplay
      * 유저가 입력한 값이 1 과 2 이외의 숫자가 들어오는지 확인한다.
      * 조건을 충족하지 못할시 오류
## 결과 - 볼과 스트라이크
* Result
   * Result클래스 안에 볼과 스트라이크의 변수를 만들어 compareNumber의 결과 값을 저장하였다.
* compareNumber 볼과 스트라이크 갯수 세기
   * userNumber와 computerNumber를 비교하여 스트라이크 갯수를 카운트. 만약 같은 자리에 수가 일치하지 않다면 userNumber가 computerNumber에 포함되는지 확인후 볼의 갯수를 카운트.
   * result객체를 생성하여 볼과 스트라이크의 값을 저장후 return
## 게임 플레이
* BaseBall
   * playGame
      * 게임이 진행되는 곳이다. 메서드가 호출되면 getRandomNumber메서드를 통해 컴퓨터의 숫자를 저장한다.
      * while문을 생성하여 게임을 종료할떄까지 반복한다.
      * while문이 시작되면 userNumber를 입력받는다.
      * compareNumber메서드를 호출하여 userNumber 와 computerNumber를 비교하여 결과값을 result에 저장한다.
      * result에 저장된 값을 가지고 resultMessage메서드를 호출하여 결과값을 출력한다. ex) 1볼 1스트라이크
      * 만약 result에 저장된 strike값이 3이면 3스트라이크로 endMessage를 출력한후 while문을 종료한다.
## main
* main class 에서 Baseball 객체를 생성한다.
* while문을 생성하여 Baseball의 playGame메서드를 실행한다.
* replayCheck를 통해 게임을 재시작할지 종료할지 결정한다. 


# 나만의 체크 포인트
## 예외처리
#### inputUserNumber
1. 중복 입력값을 처리했는가
2. 1~9까지의 숫자만 들어오는가
3. 입력값 길이가 3을 만족하는가
4. 숫자 이외의 문자가 들어오지는 않는가

#### replayInputCheck
1. 1과 2의 숫자만 들어오는가
2. 입력값 길이가 1을 만족하는가
3. 다른 문자가 들어오지는 않는가

#### 출력
1. 출력문의 요구사항을 잘 지켰는가

## clean코드
1. 메서드의 파라미터가 2개를 넘지 않는가
2. 기능별로 클래스를 잘 나누었는가
3. 주석이 없어도 코드별로 무슨 기능을 하는지 한눈에 알아볼 수 있는가
4. 자바 코드컨벤션을 잘 지켰는가

## 공부하기
* mvc 패턴
* 깃허브 (코딩애플 무료강의)
* 자바 코드컨벤션 가이드
* userNumber 중복검사에 사용한 HashSet 
* 컴퓨터 넘버를 리스트에 담는 것과 배열에 담는것중 어느것이 좋은지 공부하기
* 테스트코드 작성법 공부하기


