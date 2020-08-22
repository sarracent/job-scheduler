package snd.com.ar.jobschedulerdeletetables.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import snd.com.ar.jobschedulerdeletetables.repository.SessionRepository;

@Component
public class ScheduledTasksDeleteSessionTable {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasksDeleteSessionTable.class);

    private final SessionRepository sessionRepository;

    @Autowired
    public ScheduledTasksDeleteSessionTable(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Scheduled(cron = "${cron.expression}")
    public void cronJobDeleteSessionTable() {
        sessionRepository.deleteTable();
        log.info("---> Execute delete Session query");
    }
}
