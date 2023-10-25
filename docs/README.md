## 숫자 야구 기능 목록

---

* 게임을 새로 시작할 때마다 컴퓨터의 수 초기화
  * `Randoms` API의 `pickNumberInRange()`를 활용하여 구현
* 사용자로부터 입력 받기
  * `Console` API의 `readLine()`을 활용하여 구현
  * 입력이 1부터 9의 연속된 세 개의 숫자로 구성 되어있는지 체크
  * 입력에 중복된 숫자가 있는지 체크
  * 올바르지 않은 입력이 들어올 경우 `IllegalArgumentException`를 발생시키고 프로그램 종료
* 각 Input마다 `strikeCount`와 `ballCount`를 계산하여 출력
  * 매 Input마다 `strikeCount`와 `ballCount` 초기화
  * 입력의 각 숫자에 대하여 스트라이크, 볼 여부를 판단하고 Count 변수를 증가
  * 판단이 끝나면 현재 `strikeCount`와 `ballCount`를 바탕으로 문구를 출력
    * 3 스트라이크일 경우 게임 종료
    * 그 외의 경우 새로운 Input을 받음
* 게임 종료 문구와 재시작/종료 여부를 묻는 문구를 출력하고 User의 Input을 받음
  * Input이 1일 경우 기능의 처음 부분으로 돌아가 새로운 게임 시작
  * 1 이외의 Input이 들어올 경우 게임 종료
