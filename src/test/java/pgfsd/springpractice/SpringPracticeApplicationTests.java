package pgfsd.springpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringPracticeApplicationTests {

    @Autowired
    private SpringPracticeApplication springPracticeApplication;

    @Test
    void contextLoads() {
        assertThat(springPracticeApplication).isNotNull();
    }

}
