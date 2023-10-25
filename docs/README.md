# 구현할 기능 목록 (프로그램 진행 순서대로)
## 1. 컴퓨터의 숫자 선택
1부터 9까지 랜덤한 수를 생성.\
리스트 내에 생성한 수가 존재하는지 확인.\
존재하다면 다시 랜덤 수 생성\
존재하지 않는다면 리스트에 추가\
리스트 내의 값이 3개가 될 때까지 반복.

## 2. 사용자의 입력 검증
### 올바른 입력이 들어왔을 경우
- [x] 3번 비교한 결과를 출력하고 사용자의 입력을 다시 받음
### 잘못된 입력이 들어왔을 경우
#### 3개의 숫자가 서로 다른 숫자가 아닐 경우
- [x] IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
#### 숫자가 아닌 값을 입력했을 경우
- [x] IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 3. 비교한 결과
사용자의 입력을 리스트의 순서대로 컴퓨터의 수와 비교 -> strikeCount\
사용자의 입력이 컴퓨터의 수 중 존재하는지 확인 -> ballCount\
ballCount = ballCount - strikeCount 임
3 스트라이크가 나오기 전까지 계속해서 사용자의 입력 받고 비교 실행
### 3스트라이크일 경우
게임을 종료하거나 다시 시작할 수 있다.재시작/종료를 구분하는 1과 2 중 하나의 수를 입력 받는다.

예외처리

- [x] 사용자의 입력이 숫자가 아닐 경우
- [x] 1또는 2가 아닌 다른 숫자를 입력했을 경우 

IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
### 하나도 맞지 않을 경우 낫싱을 출력하고 다시 입력 받는다.
### 부분적으로 맞았을 경우 결과를 출력하고 다시 입력 받는다.

---
## 클래스를 나눠보기
### 사용자의 입력을 처리할 클래스 UserInputHandler
#### userInputThreeNumber 메소드
- 사용자의 수를 입력받는 메소드.
#### userInputGameFlag 메소드
- 게임을 다시 시작할지, 종료할지를 사용자에게 입력받는 메소드 
#### userInputThreeNumberVerification 메소드
- 사용자가 입력한 3자리의 수가 조건에 부합하는지를 검증하는 메소드
### 컴퓨터의 RandomNumber를 생성할 클래스 ComputerNumberGenerator
#### createNewNumber 메소드
- 컴퓨터의 수를 생성함
### 사용자의 입력에 대한 게임 결과를 처리할 클래스 GameScoreHandler
#### calculateScore 메소드
- ballCount, strikeCount 점수를 계산하는 메소드
#### printScore 메소드
- 계산된 점수를 출력문 형식에 맞춰서 출력하는 메소드
### 게임의 시작과 끝을 결정하는 클래스 Game 
#### start 메소드
- 게임을 시작시키는 메소드
### Scanner의 생성과 종료를 담당하는 Console 클래스
단위 테스트 진행시에는 모두 성공하지만 전체 테스트는 실패하는 현상이 발생했다.
계속해서 확인한 결과 한번의 애플리케이션 실행 종료시에 Scanner를 종료하고 다시 생성하지 못했기에 발생하는 현상으로 보였다.
따라서 Scanner가 null이면 Scanner를 생성해주는 Console의 getInstance메소드를 만들어주고
만약 Scanner가 열려있으면 애플리케이션 종료시에 Scanner를 null로 만들어주는 Console의 close()메소드를 만들어주었다.
이를 통해 여러개의 테스트를 한번에 pass할 수 있었다.