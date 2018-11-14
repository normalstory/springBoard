-- 운영db에 없는 테이블을 만들어서 필터 검증역할 수행 : rangerSetup(){ ... populater.setContinueOnError(false); }
-- (2번째 안전장치 마련용: dbTest.properties에 사용자 아이디를 운영DB로 잘못 바꾸는 경우 대비 )

--테스트 시, 데이터 초기화 용 
delete from springboard;

--commit; <--자동으로 오토커밋 해준다.


