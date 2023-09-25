-- system 계정에서 생성된 계정들 확인하기, 한줄만 실행: ctrl+enter
select username,account_status from dba_users; -- user명, 잠금상태인지 확인

--scott 계정을 잠금상태로 변경해보자
alter user scott account lock;

--scott 계정의 lock 을 풀어보자
alter user scott account unlock;

-- angel 계정을 만들어보자(비번 a1234)
create user angel IDENTIFIED by a1234; --권한 오류, c##을 붙여야만 한다
create user c##angel IDENTIFIED by a1234; --성공적으로 생성

--생성된 계정을 삭제하려면
drop user c##angel;

--c## 을 안붙이고 계정을 생성하려면 세션을 변경한후 생성해야만 한다
alter session set "_ORACLE_SCRIPT"=true;
create user angel IDENTIFIED by a1234;

--권한을 줘야만 접속과 데이타저장이 가능하다
grant connect,resource to angel;

--angel 에 테이블을 생성할수 있도록 tablespace 잡기
alter user angel default tablespace users quota unlimited on users;



