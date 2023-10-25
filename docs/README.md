# 숫자 야구 게임
1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임입니다.

## URL
https://github.com/woowacourse-precourse/java-baseball-6#%EF%B8%8F-%EA%B3%BC%EC%A0%9C-%EC%A7%84%ED%96%89-%EC%9A%94%EA%B5%AC-%EC%82%AC%ED%95%AD

## STACKS
* JAVA (ECLIPSE IDE)

## ALGORITHM
1. 컴퓨터가 서로 다른 랜덤한 값 3개 추출
2. 사용자가 서로 다른 숫자 3개 입력
3. 리스트로 변환 후, 컴퓨터와 사용자의 숫자 비교
4. 맞을 시 재시작 / 종료 선택

## FUNCTION
* 랜덤 값 추출 -> camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용
* 사용자 입력값 -> camp.nextstep.edu.missionutils.Console의 readLine()을 활용
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
* for, while 등 반복문 사용
* if, else 등 조건문 사용