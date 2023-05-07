package example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title
import org.slf4j.*
import groovy.util.logging.Slf4j

@Slf4j
@Title("DogRestController Specification")
@Narrative("The Specification of the behaviour of the DogRestController.")
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
class TestController extends Specification {

    //private Logger logger = org.slf4j.LoggerFactory.getLogger(TestController.class);

    @Autowired
    private MockMvc mvc

    def "when get is performed then the response has status 200"() {
        expect: "Status is 200"
        log.info "simple test"
        mvc.perform(MockMvcRequestBuilders.get("/dogs"))
        .andExpect(MockMvcResultMatchers.status().isOk())
    }

    def "when get for a single item then the response has status 200"() {
        expect: "get a single item status as 200"
        mvc.perform(MockMvcRequestBuilders.get("/dog/{id}", 1))
        .andExpect(MockMvcResultMatchers.status().isOk())
    }
    
}
