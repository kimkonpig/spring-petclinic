package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/*
AOP Practice
https://atoz-develop.tistory.com/entry/Spring-%EC%8A%A4%ED%94%84%EB%A7%81-AOP-%EA%B0%9C%EB%85%90-%EC%9D%B4%ED%95%B4-%EB%B0%8F-%EC%A0%81%EC%9A%A9-%EB%B0%A9%EB%B2%95
 */

@Component
@Aspect
// Aspect 역할 클래스 명시
// xml 설정 파일에 <aop:aspectj-autoproxy/> 입력 필요
// @Aspect 어노테이션이 있는 클래스를 자동으로 찾아서 설정해주는 태그
public class LogAspect {

	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Around("@annotation(LogExecutionTime)") // Around가 적용될 PointCut을 명시 :
												// @LogExecutionTime 어노테이션
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object proceed = joinPoint.proceed(); // 핵심 기능 실행

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());

		return proceed;
	}

}
