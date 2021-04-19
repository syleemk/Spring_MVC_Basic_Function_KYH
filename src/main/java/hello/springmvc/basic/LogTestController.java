package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // 로그를 찍을 때 로깅 레벨을 정할 수 있음
        // 현재 로그는 어느 상태의 레벨이다
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name); // 디버그 할때 보는 정보, 개발 서버 같은 곳에서 사용
        log.info("info log = {}", name); // 중요한 정보, 운영 서버같은 곳에서도 봐야하는 정보
        log.warn("warn log = {}", name); // 경고, 위험한 것이다.
        log.error("error log = {}", name); // 에러, 당장 해결해야한다.

        return "ok";
    }
}
