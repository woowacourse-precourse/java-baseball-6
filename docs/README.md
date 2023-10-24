# 1주차 프리코스 숫자야구

## 구현할 기능 목록

---


### Controller
요청 흐름에 알맞는 적절한 View, Service, Domain 을 호출합니다.  
- `GameController`
  - 게임시 흐름에 따라 알맞는 비지니스 로직 및 화면을 호출해주는 클래스

### Domain
- `User`
  - 사용자의 숫자
- `Computer`
  - 컴퓨터의 숫자
- `Numbers`
  - 3자리 숫자를 저장하는 일급 컬렉션
  - `User`, `Computer` 에 사용되어 숫자값에 대한 비즈니스 검증 로직을 수행

### DTO
계층 간 데이터 전달에서 사용됩니다. 입력받은 값을 전달하는 경우 생성자 단계에서 유효성 검증을 수행 후 객체를 생성합니다.

- `UserNumberRequest`
  - 게임 진행 중 사용자가 입력한 숫자값이 Model 계층으로 전달될 때 사용
- `RestartAnswerRequest`
  - 게임 종료 후 재시작 여부 입력한 값이 
- `ResultResponse`
  - 입력한 숫자의 결과값을 저장


### Service
게임 진행 시 필요한 비즈니스 로직을 수행합니다. 
- `ComputerService`
  - 컴퓨터 도메인 생성
게임 진행에 필요한 비지니스 로직을 수행합니다. 
- `GameService`
  - 게임 진행 및 결과 수집
- `UserService`
  - 사용자 도메인 생성

### View
입력값에 대한 간단한 검증(`null`, `isBlank` 여부)을 수행합니다. 이외 비지니스 요구사항은 Service 레이어에서 검증합니다.
- `InputView`
  - 사용자 입력폼을 제공하는 클래스
- `OutputView`
  - 사용자에게 보여줄 값을 출력하는 클래스 
- `GameMessage`
  - 게임 진행 시 출력에 필요한 상수값

## 설정 파일

---
비지니스 요구조건 설정값을 관리하는 클래스입니다.
### 설정 클래스
- `GameConfig`
  - 숫자 개수, 컴퓨터 숫자 범위 등이 상수로 정의되어 있는 클래스 

## 예외 처리

---
### 예외 클래스
입력 값이 잘못되었을 때 사용되는 커스텀 예외 클래스입니다. `ErrorCode` 열거체를 필드로 가지며 예외 발생 시 해당 `ErrorCode` 의 `message` 필드가 메시지로 추가됩니다.
- `UserInputException`
  - `illegalArgumentException` 상속
  1. 입력한 값이 3글자가 아닌 경우
  2. 입력한 값이 숫자가 아닌 경우
  3. 입력한 값의 문자가 중복인 경우
  4. 입력한 값이 0으로 시작하는 경우
  5. 3스트라이크 후 재시작 입력 값이 0 또는 1이 아닌 경우

### 예외 메시지
오류 코드등 확장성을 위해 열거체로 만들었습니다.
- `ErrorCode`
  - 예외 메시지를 가지고 있는 열거체

## 흐름도

---
1. 사용자가 `GameController`에게 게임 시작 요청
2. `GameController`는 입/출력에 필요한 화면(`InputView`, `OutputView`)을 호출한다.
3. `GameController`은 컴퓨터 숫자 도메인(`Computer`)와 입력값(`UserNumberRequest`) `GameService` 에게 전달한다.
4. 
   1. `GameService`는 입력값을 검증하고 `User` 도메인을 생성한다.
   2. 받아온 `User`와 `Computer` 의 숫자 일치 여부를 계산 후 `GameController` 에게 결과를 반환한다.
5. 사용자가 맞출 때까지 2 ~ 4번 과정을 반복한다.
6. `GameController`는 재시작 여부 확인에 필요한 화면(`InputView`, `OutputView`)을 호출한다.
7. 입력값에 따라 종료하거나, 1 ~ 6번 과정을 다시 반복한다.

## 테스트

---
### 기능 테스트

### 단위 테스트

### 통합 테스트