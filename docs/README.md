# 기능 목록
## 컴퓨터의 수 생성
> 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
> 
> 
> __camp.nextstep.edu.missionutils__ 에서 제공하는 __Randoms__ 및 __Console API__ 를 사용하여 구현
> >Random 값 추출은 __camp.nextstep.edu.missionutils.Randoms__ 의 __pickNumberInRange()__ 를 활용
## 입출력
### 입력
> 컴퓨터의 수를 맞추기 위한 3자리의 수
> 
> 
> 게임의 재시작 및 종료를 구분하기 위한 1, 2 중 하나의 수
> 
> 
> 잘못된 값 입력 시 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
### 출력
> 컴퓨터의 수와 비교하여 숫자와 위치가 동일할 경우 1 스트라이크
> 
>
> 컴퓨터의 수 중 동일한 숫자는 있지만 위치가 다를 경우 1볼
***