package example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title
import org.slf4j.*
import groovy.util.logging.Slf4j

import example.controller.DogRestController

@Title("Application Specification")
@Narrative("Specification which beans are expected")
@SpringBootTest
@Slf4j
public class TestLoadContext extends Specification {

//    private Logger logger = org.slf4j.LoggerFactory.getLogger(TestLoadContext.class);

    @Autowired(required = false)
    private DogRestController controller

    public void "when context is loaded then all expected beans are created"() {
        expect: "the DogRestController is created"
        log.info "simple test"
        controller != null
    }
}