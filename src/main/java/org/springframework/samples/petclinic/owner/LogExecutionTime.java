package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 어노테이션을 메소드에 사용할 것임을 설정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션이 RUNTIME까지 유지되도록 설정
public @interface LogExecutionTime {

}
