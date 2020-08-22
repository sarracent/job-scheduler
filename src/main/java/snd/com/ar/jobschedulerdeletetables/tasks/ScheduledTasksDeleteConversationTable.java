package snd.com.ar.jobschedulerdeletetables.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import snd.com.ar.jobschedulerdeletetables.repository.ConversationRepository;

@Component
public class ScheduledTasksDeleteConversationTable {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasksDeleteConversationTable.class);

    private final ConversationRepository conversationRepository;

    @Autowired
    public ScheduledTasksDeleteConversationTable(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Scheduled(cron = "${cron.expression}")
    public void cronJobDeleteConversationTable() {
        conversationRepository.deleteTable();
        log.info("---> Execute delete Conversation query");
    }
}
