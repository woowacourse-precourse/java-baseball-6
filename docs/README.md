# 미션 - 숫자 야구

---

## ✏️ 기능 요구 사항

### 상대방(컴퓨터) 
- 서로 다른 임의의 수 3개 선택 (1~9)
- 라이브러리
  ```jsx
   camp.nextstep.edu.missionutils.Randoms
   pickNumberInRange();
  ```

### 플레이어
- 서로 다른 3자리의 수
   - 입력
     ```jsx
     숫자를 입력해주세요 :
     ```
      ```jsx
      camp.nextstep.edu.missionutils.Console
      readLine();
     ```
   - 잘못된 값 입력한 경우
      - IllegalArgumentException 발생 후 종료
      - 문자열을 입력한 경우
      - 같은 숫자가 들어간 경우
      - 0이 들어간 경우
   - 게임 재시작 : 1
   - 게임 종료 : 2

### 결과
- 같은 수가 같은 자리에 있는 경우 : 스트라이크
- 같은 수가 다른 자리에 있는 경우 : 볼
- 같은 수가 전혀 없는 경우 : 낫싱
- 모두 맞히면 게임 종료
  ```jsx
  3개의 숫자를 모두 맞히셨습니다! 게임 종료
  ```
  ```jsx
  게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
  ```

  - 잘못된 값 입력한 경우
    - IllegalArgumentException 발생 후 종료
    - 문자열을 입력한 경우
    - 같은 숫자가 들어간 경우
    - 0이 들어간 경우

  
---

## 💻 프로그래밍 요구 사항
- JDK 17
- 프로그램 실행의 시작점은 Application main()
- build.gradle 파일 변경 금지
- System.exit() 호출 금지
- ApplicationTest의 모든 테스트가 성공해야 함
- 패키지 이름 수정이나 이동 금지
- Java 코드 컨벤션 가이드 준수

- javadocs 
  <br>
  매 public class에 쓰임 (클래스 안에 public, protected 멤버에 쓰임)
  <br>
  예외 : 오버라이드





