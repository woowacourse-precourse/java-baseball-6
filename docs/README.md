# Condition :
- 숫자는 모두 서로 다른 수로 이루어짐
- 컴퓨터 : 1~9 수 랜덤 생성
- 사용자 입력에 따라 결과 출력
  (스트라이크 / 볼 / 낫싱)
```java
import camp.nextstep.edu.missionutils;
```
- camp.nextstep.edu.missionutils의 Randoms, Console API를 사용할 것

# Input :
- 사용자 : 서로 다른 3개의 숫자 입력
- 게임 종료 후 (1 : 다시 시작 / 2 : 종료) 가능
- 잘못된 값 입력 : IllegalArgumentException 발생 후 애플리케이션 종료

# Output :
- 같은 수, 같은 자리 = 스트라이크
- 같은 수, 다른 자리 = 볼
- 같은 수가 전혀 없음 = 낫싱
- 볼, 스트라이크 순서 개수로 표시
  (ex. 1볼 1스트라이크)

# Requirements :
````
1. JDK 17버전 실행 가능
2. 실행의 시작점은 Application의 main()
3. 외부 라이브러리 사용 불가
4. JAVA 코드 컨벤션 가이드 준수
5. 프로그램 종료 시 System.exit() 호출 X
6. 파일, 패키지 이름을 수정 및 이동 금지
````

# Process :
### *Model* 
#### : 비즈니스 로직을 담당, 입출력 데이터 관리
- [x] (랜덤 수 생성) 클래스 (generateNumber)
- [x] (잘못된 값 입력) 예외처리 (PlayerNumber)
- [ ] 게임 재시작, 종료 로직 구현
---
### *View*
#### : 컨트롤러를 통해 모델에서 정보를 받아 출력
- [x] (숫자 입력 화면) 클래스 (InputView)
- [x] (게임 출력 화면) 클래스 (OutputView)
---
### *Contoller*
#### : 모델과 뷰의 중재자 담당
- [ ] (입력값과 정답 숫자 비교) 클래스
- [x] (게임 시작과 중재자 역할) 클래스 (BaseballGame)


### *GameManager*
#### : 게임의 실행을 관리
- [ ] Application.java