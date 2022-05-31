package inflearn.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 컴포넌트 default 스캔 시작 위치는 @ComponentScan의
// 프로젝트 루트에 @ComponentScan을 붙이고 하위 클래스를 스캔
@Configuration
@ComponentScan(
        basePackages = "inflearn.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
