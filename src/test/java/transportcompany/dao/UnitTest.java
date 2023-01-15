package transportcompany.dao;

import org.junit.jupiter.api.AfterEach;
import transportcompany.configuration.SessionFactoryUtil;

public class UnitTest {

    @AfterEach
    void afterEach() {
        SessionFactoryUtil.closeSessionFactory();
    }

}
