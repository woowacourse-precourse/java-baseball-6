# 구현 기능 목록

### 랜덤 숫자 생성
- camp.nextstep.edu.missionutils.Randoms에서 제공하는 pickNumberInRange() 활용

### 사용자 입력 확인
- camp.nextstep.edu.missionutils.Console 에서 제공하는 readLine()활용
- 잘못된 입력 들어올시 IllegalArgumentException 발생후 종료

### 답안과 사용자 입력 비교
- 입력한 수에 대한 결과를 볼,스트라이크 개수로 표시

### 랜덤숫자 담을 Wrapper class
- 생성자에서 랜덤숫자 생성
- 인덱스를 매개변수로 받아와 해당 인덱스값 반환하는 getter 구현

### 게임 진행 or 종료 판단

---

## v 1.1

### 사용자 입력 담을 Wrapper class
- 생성자에서 입력받아와 클래스의 인스턴스 변수에 저장
- 랜덤숫자와 사용자 입력 비교하여 블,스트라이크 카운팅하는 함수