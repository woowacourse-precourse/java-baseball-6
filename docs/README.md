## 구현 순서

### while 문 (큰 틀)
+ 시작
   + "숫자 야구 게임을 시작합니다." 시작 문구
   + game 진행 while문
     
+ 종료
   + 게임 진행 여부는 1 과 2 입력으로 받음
   + 1 : continue
   + 2 : break

### game 알고리즘
+ 랜덤
   + camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
   + Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
   + 서로 다른 숫자
+ 출력
   + 같은 수가 같은 자리에 있으면 스트라이크
      + 3스트라이크인 경우, 게임 종료 
   + 다른 자리에 있으면 볼
   + 같은 수가 전혀 없으면 낫싱
   + 볼, 스트라이크 둘 다 있으면 볼 먼저 출력
+ 입력
   + 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
   + 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생
      + 3자리 수 이상 입력
      + 0이 포함된 경우
      + 숫자가 아닌 경우
