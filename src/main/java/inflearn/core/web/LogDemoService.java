package inflearn.core.web;

import inflearn.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> provider;

    public void logic(String testId) {
        MyLogger logger = provider.getObject();
        logger.log("service id = " + testId);
    }
}
