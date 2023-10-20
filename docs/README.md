## 진행 플로우

1. 숫자 야구 게임을 시작한다는 문구 출력
2. 컴퓨터의 값을 랜덤 함수를 통해 추출
    - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
3. 사용자가 숫자를 입력
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

    1. 만약 잘못된 값을 입력한다면 예외처리 후 애플리케이션 종료 (IllegalArgumentException)
4. 입력된 수에 대한 결과를 출력
5. 반복하며 작업하다가 3개의 숫자를 모두 맞힐 경우 게임 종료
    1. 게임 종료 후 게임을 새로 시작할 것인지 종료할 것인지 안내 문구
    2. 입력된 결과를 바탕으로 다시 시작 or 시스템 종료 진행.

## 기능 목록

- 메인함수 **Application**
- 컴퓨터 **Computer** -> num 존재.
    - 컴퓨터의 값을 지정해주는 함수 **RandomNum()**  
      임의의 3가지 숫자를 지정하여 저장
    - 결과값을 분석하는 함수 **Check()**
      볼과 스트라이크의 개수를 파악 후 리턴함.
      만약 에러가 발생하면 예외 처리를 하고 게임을 종료함.
- 게임을 실행하는 함수 **GameStart()**
    1. 숫자를 입력해달라는 문구 출력
    2. 사용자의 입력을 받아옴
    3. 받아온 입력의 결과값을 출력
    4. 1~3번 반복
    5. 만약 결과값이 게임 종료 조건을 만족했다면 게임을 끝내는 문구 출력
