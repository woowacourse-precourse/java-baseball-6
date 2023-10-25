<h1>숫자 야구 게임 기능 목록</h1>
: 1부터 9까지 서로 다른 3자리 수를 맞추는 게임.

## 컴퓨터 기능
### 숫자 선택 기능
- 서로 다른 수로 이루어진 세자리 수 리스트 생성
  - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용

## 사용자 기능
### 숫자 입력 기능
- camp.nextstep.edu.missionutils.Console의 readLine()을 활용
    - 1에서 9까지 서로 다른 세 개의 정수 입력시 통과
    - 잘못된 값 입력시 IllegalArgumentException을 발생
    

## 숫자 비교 기능
- 같은 수가 같은 자리에 있으면 스트라이크
- 같은 수가 다른 자리에 있으면 볼
- 같은 수가 전혀 없으면 낫싱

## 출력 기능
### 게임시작 문구 출력 기능
- 게임 시작 문구 출력
### 플레이 결과 출력 기능
- Compare 클래스에서 return 받은 값으로 플레이 결과 출력

### 게임 재시작/종료 여부 문구 출력 기능 
- printRestartOrEnd 메서드 구현
 

## 예외상황 처리 기능
### 사용자의 입력값 유효성 검사
- IllegalArgumentException 발생시 프로그램 종료
    - 중복 숫자 입력 여부
    - 아무것도 입력하지 않은 경우
    - 정수 이외의 값 입력 여부(실수, 문자)
    - 세 자리 이상의 경우
    - 세 자리 이하의 경우
### 게임 재시작/종료
- 재시작(1) 종료(2) 외의 값 입력한 경우
- 아무것도 입력하지 않은 경우

## 게임 재시작/종료 기능
- 스트라이크 개수가 3이면 종료 여부 묻기("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하여 사용자의 입력값 받기
  - 1과 2중 하나의 값만을 입력받음
    - 사용자의 입력값이 1이면 게임 재시작
    - 사용자의 입력값이 2이면 프로그램 종료
- 스트라이크 개수가 3이 아닐 경우 게임 계속 진행
