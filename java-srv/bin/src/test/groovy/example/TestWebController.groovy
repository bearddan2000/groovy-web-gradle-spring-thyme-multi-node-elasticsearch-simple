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
@Title("WelcomePageRedirect Specification")
@Narrative("The Specification of the behaviour of the WelcomePageRedirect.")
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
class TestWebController extends Specification {

    @Autowired
    private MockMvc mvc

    def "when nav to index page then the response has status 200"() {
        expect: "Status is 200"
        mvc.perform(MockMvcRequestBuilders.get("/"))
        .andExpect(MockMvcResultMatchers.status().isOk())
    }  
}