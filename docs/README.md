# 1주차미션 - ⚾ 숫자 야구

## 🐣 구현 기능 목록

### 1. 상대방(컴퓨터) 입력
- camp.nextste️p.edu.missionutils의 Randoms 및 Console API를 사용
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용
- 1~9까지의 숫자 3개를 반환 하도록 한다.

### 2. 사용자 입력
- camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- user 리스트에 문자열을 정수로 변환하여 저장한다.
- 잘못된 값(3개의 숫자 이외의 값)을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.
- 게임이 끝난 경우 재시작/종료를 위해 1/2를 입력한다.

### 3. 게임 구현
- 필요한 변수 목록
  - computer : arrayList, 상대방의 입력값을 저장한다.
  - user : arrayList, 사용자의 입력값을 저장한다.
  - strke, ball : int, 각각 스트라이크와 볼의 개수를 저장한다.
- computer, user 리스트를 모두 비교하면서 탐색한다.
- 이중 반복문으로, 조건에 맞게 strike, ball 변수 값을 1씩 증가 시킨다.
  - 스트라이크 : 같은 숫자, 같은 위치
  - 볼 : 같은 숫자, 다른 위치
  - 낫싱 : 같은 숫자가 전혀 없음
- 사용자가 틀렸을 경우, user 리스트를 초기화하고 다시 반복문을 실행한다.

### 4. 결과 출력
- count된 strike, ball 을 출력한다 (조건문 사용)
- 사용자가 숫자 3개를 모두 맞추면, 게임이 종료된다.