-- 2023-09-20
-- sal 이 1000~2000 사이 출력
select ename,sal,comm from emp where sal>=1000 and sal<=2000; --방법1
select ename,sal,comm from emp where sal BETWEEN 1000 and 2000;  --방법2

--sal 이 1000 -2000 을 제외하고 출력
select ename,sal,comm from emp where sal not BETWEEN 1000 and 2000; --방법1
select ename,sal,comm from emp where sal <1000 or sal>2000; --방법2

-- comm 이 null 인 데이타 조회
select * from emp where comm is null;
-- comm 이 null 이 아닌 데이타 조회
select * from emp where comm is not null;
--comm 이 null 인경우 0으로 출력,마지막 컬럼에 sal+comm 을 더한값을 출력
select ename,sal,comm,sal+comm from emp; --숫자+null=null
--NVL(컬럼명,값) : 해당 컬럼값이 null 이면 0으로 출력(mysql 에는 isnull)
select ename,sal,NVL(comm,0),sal+NVL(comm,0) from emp; --컬럼명을 주목

--나중에 자바로 가져갈경우 컬럼인덱스나 컬럼명으로 가져간다. 그래서 컬럼명이 복잡한경우
-- 별칭을 지정을 한다
select ename as "사원명",sal as "연봉" from emp; --"별칭" ,단 공백이 없을경우 "" 생략
select ename 사원명 ,sal 연봉 from emp;
select empno "사원 번호",sal 연봉 from emp;--별칭에 공백이 있는경우 반드시 ""안에(as는 생략)

select ename 사원명,sal 연봉,NVL(comm,0) 수수료,sal+NVL(comm,0) 총연봉 from emp;

--총 글갯수 출력
select count(*) from emp;
select count(*) count from emp;

-- 문자열을 이어서 출력 ||  ,컬럼명은 member 로 출력해보자
select ename||'님의 직업은 '||job||'입니다' member from emp;

-- xx 님의 총 연봉은 xxx 입니다(sal+comm, 널일경우 100 으로 계산, 제목은 회원연봉
select ename||'님의 연봉은 '||(sal+NVL(comm,100))||'입니다' 회원연봉 from emp;

--empno 여러개 조회
select empno,ename from emp where empno=7369 or empno=7788 or empno=7900;

--여러개 조회시 in 을 사용해보자
select empno,ename from emp where empno in (7369,7788,7900);

--위의 3개의 empno 을 빼고 출력
select empno,ename from emp where empno not in (7369,7788,7900);

--ename,job 을 출력하는데 job 이 salesman이거나 analyst,manager 3개의 직업만 출력
select ename,job from emp where job in ('SALESMAN','ANALYST','MANAGER');

--날짜로 조건
select * from emp where hiredate='80/12/17';
select * from emp where hiredate='1980-12-17';
select * from emp where hiredate>='1980-01-01' and hiredate<='1981-10-10';

--현재 날짜 조회
select sysdate from dual; 
--내일 날짜
select sysdate+1 from dual;
--to_char 변환함수를 이용해서 조회
select to_char(sysdate,'yyyy-mm-dd') from dual;
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual; --mi :분 mm:월
select to_char(sysdate,'yyyy-mm-dd am hh:mi') from dual; --오전오후표시 am또는pm
select to_char(sysdate,'yyyy-mm-dd') from dual;

--emp 에서 ename,hiredate(yyyy-mm-dd) 를 출력하는데 1981년에 입사한사람만 출력
-- 제목은 사원명, 입사일
select ename 사원명,to_char(hiredate,'yyyy-mm-dd') 입사일 from emp 
    where to_char(hiredate,'yyyy')=1981;

--그룹함수: count,max,min,avg,sum
select count(*) from emp; --전체 데이타 갯수
select avg(sal) from emp; --sal 의 평균  2073.21428571......
select round(avg(sal),1) from emp; --보통 ?균을 구할때는 round 함수와 같이 사용한다 2073.2
select round(avg(sal),0) from emp; --2073
select round(avg(sal),-1) from emp; --2070
select round(avg(sal),-2) from emp; --2100

select sum(sal) from emp; --sal 의 총 합계 29025
select min(sal) from emp; --제일 작은 급여
select max(sal) from emp; --제일 큰 급여

--제일 작은 급여를 받는 사람의 이름을 알아보세요--sub query
select ename,sal from emp where sal=(select min(sal) from emp);
--제일 큰 급여를 받는 사람의 이름을 알아보세요
select ename,sal from emp where sal=(select max(sal) from emp);
--SCOTT 의 직업과 같은 직업을 가진 사람들 조회(ENAME,JOB,SAL)
select ename,job,sal from emp where job=(select job from emp where ename='SCOTT');
--allen 보다 더 높은 연봉을 받는 사람의 인원수는?
select COUNT(*) from emp WHERE sal>(select sal from emp where ename='ALLEN');

--GROUP BY
--JOB 직업별로 일단 인원수를 구해보자
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB;
--위의 결과를 직업의 오름차순으로 출력
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 직업;
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 1;
-- 인원수의 오름차순으로 출력
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 인원수;
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 2;

--직업별로 인원수,평균연봉과 최저연봉,최고연봉 을 출력해보자
SELECT JOB 직업,COUNT(*) 인원수,ROUND(AVG(SAL),0) 평균연봉,MAX(SAL) 최고연봉,
   MIN(SAL) 최저연봉 FROM EMP GROUP BY JOB;
   
-- 그룹에 대한 조건을 줄경우 HAVING 
--위의 SQL문에 인원수가 3명이상인 그룹만 출력
SELECT JOB 직업,COUNT(*) 인원수,ROUND(AVG(SAL),0) 평균연봉,MAX(SAL) 최고연봉,
   MIN(SAL) 최저연봉 FROM EMP GROUP BY JOB HAVING COUNT(*)>=3;
   
-- 오라클 함수들
--숫자함수
select abs(-5),abs(5) from dual; --abs : 절대값으로 출력(양수값)
select ceil(2.1),ceil(2.9) from dual; -- ceil(숫자):무조건 올림
select floor(2.1),floor(2.9) from dual; -- floor(숫자):무조건 내림
select mod(7,2) from dual; --mod : 나머지  1
select power(2,3) from dual; --power:지수승   8

--변환함수
select '7'+7 from dual;
select to_number('7')+7 from dual;
select to_char(sysdate,'yyyy-mm-dd') from dual;

--문자함수
select concat('hello','world') from dual; --문자열 합치기
select 'hello'||'world' from dual; --문자열 합치기

--나중에 자바에서 단어입력하면 그 단어를 포함한 게시글을 출력한던가 할때
select * from board where subject like '%'||변수명||'%'; --오라클
select * from board where subject like concat('%',변수명,'%');--mysql

select LPAD(23500,10,'*') FROM DUAL;  --총 10자리중 남는왼쪽자리에 * 로 채우기
select RPAD(23500,10,'*') FROM DUAL;  --총 10자리중 남는오른쪽자리에 * 로 채우기

SELECT INITCAP('HELLO') FROM DUAL; --첫글자만 대문자로
SELECT LOWER('HELLO') FROM DUAL; --전체 소문자로
SELECT UPPER('HELLO') FROM DUAL; --전체 대문자로

SELECT INITCAP(ENAME),LOWER(ENAME),UPPER(ENAME) FROM EMP;

SELECT SUBSTR('HELLO KITTY',3,3) FROM DUAL; --3번째부터 3글자 추출
SELECT SUBSTR('HELLO KITTY',-3,3) FROM DUAL; --뒤에서 3번째부터 3글자 추출

--ENAME,SAL 출력(ENAME은 두글자만 추출해서 출력후 뒤에 '***' 붙여서 출력, 
--SAL 은 총 7자리로 출력하는데 앞에 **로 채워서 출력
SELECT SUBSTR(ENAME,1,2)||'***' 사원명,LPAD(SAL,7,'*') 연봉 FROM EMP;

-- 양쪽 공백 제거
SELECT '*'||'   HELLO    '||'*' FROM DUAL;
SELECT '*'||TRIM('   HELLO    ')||'*' FROM DUAL;

SELECT DECODE(2,1,'ONE',2,'TWO',3,'THREE',4,'FOUR') FROM DUAL;
SELECT ENAME,DEPTNO,DECODE(DEPTNO,10,'부산',20,'대구',30,'제주도') FROM EMP;

--문제풀기
--1. emp테이블에서 ename a나 s로 시작하는사람 출력(대소문자 상관없음)
select * from emp where lower(ename) like 'a%' or lower(ename) like 's%'; 
  
--2. emp테이블에서 ename 에서 두번째 글자가 'A' 인사람 출력
select * from emp where ename like '_A%';
  
--3. job 에서 같은 직업군일경우 한번씩만 출력하시오(오름차순으로 출력)
select DISTINCT job from emp order by 1;
  
--4. job 종류별로 인원수를 구하시오(인원수의 내림차순으로 출력)
select job,count(*) count from emp group by job order by count desc;

--5. job 종류별로 sal 의 평균급여를 구하시오,평균급여의 오름차순으로 출력
select job,round(avg(sal),0) 평균급여 from emp group by job order by 2;

--6. job 종류별로 sal 의 최대값과 최소값을 구하시오
select job,max(sal) 최대급여,min(sal) 최소급여 from emp group by job;

--7. deptno 가 10인경우 '홍보부'
--   20 인경우 '개발부' 30인경우 '관리부' 부서를 구하여
--   ename, 부서 를 출력하시오
select ename,deptno,decode(deptno,10,'홍보부',20,'개발부',30,'관리부') 부서
  from emp;
  
--8. 급여(sal)가 sal 의 평균보다 더 높은 사람만 ename 과 sal 을 출력하시오
select ename,sal from emp where sal>(select avg(sal) from emp);

--9. hiredate 에서 월이 5월인 사람만 ename 과 hiredate 를 출력하시오
select ename,hiredate from emp where to_char(hiredate,'mm')=5;

--10. SCOTT 의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력하라
select ename,sal from emp where sal>=(select sal from emp where lower(ename)='scott');