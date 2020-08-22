package snd.com.ar.jobschedulerdeletetables.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcSessionRepository implements SessionRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcSessionRepository.class);

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcSessionRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void deleteTable() {
        String sql = "DELETE FROM session WHERE last_activity < DATE_SUB(NOW(), INTERVAL 12 MONTH)";
        int numberOfRowsAffected = jdbc.update(sql);
        log.info("---> Number Of Rows Session Delete Affected: " + numberOfRowsAffected);
    }
}
