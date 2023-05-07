import spock.lang.Specification;
/*
@Grab(group='org.slf4j', module='slf4j-api', version='1.7.7')
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.2')
*/
import spock.lang.Narrative
import spock.lang.Title
import org.slf4j.Logger

@Title("Spock Specification")
@Narrative("Specification tests setup for spock")
public class TestMain extends Specification {
  private Logger logger = org.slf4j.LoggerFactory.getLogger(TestMain.class);

  public void "smoke test"(){
    expect: "simple test"
    logger.info("assert 1+1 == 2")
    1 + 1 == 2
  }
}