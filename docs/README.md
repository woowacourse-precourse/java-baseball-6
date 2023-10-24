# 기능 요구 사항

## 숫자 랜덤 생성 기능
## 숫자 랜덤 중복을 걸러 주는 기능
## 그 수를 보관할 컴퓨터

## 유저가 수를 입력 하는 기능
## 유저가 잘 못 된 수를 입력시 익셉션 생성 -> 종료
## ! e.입력 받은 수가 1 ~ 9 범위 밖일 경우
## ! e.입력 받은 수가 3자리가 아닐 경우
## ! e.입력 받은 수가 중복이 있을 경우
## ! e.입력 받은 수가 숫자가 아닐 경우

## 숫자를 index 로 접근을 하여 비교 하여 처리 (자료형을 맞춰준다)
## 동일한 index 에 유저 값 = computer 값이 있으면 스트라이크
## 다른 index 에 유저 값 = computer 값이 있으면 볼
## 아무 것도 못 맞추면 count 에 0을 담아 사용
## 출력 조건은 ball -> strike

## 유저의 게임 시작, 종료 기능
## 1번을 누르면 재시작 -> 새로운 컴퓨터의 세팅
## 2번을 누르면 프로그램 종료
## ! 1,2 이외의 숫자를 받으면 예외를 출력하며 종료 

-------

# Edit
## Application : view               - 야구 게임을 진행 
## BaseballController : Controller  - 야구 게임을 조립  
## ComPuTaVO : VO                   - 콤푸타 에게 생명을 
## ComPuTaService : Service         - 콤푸타 조립 예정 
## GameService : Service            - 게임 관련 처리 
## RandomService : Service          - 램덤 관련 처리 
## userChatService : service        - 유저 입출력 관련 