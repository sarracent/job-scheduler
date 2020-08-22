package snd.com.ar.jobschedulerdeletetables.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcConversationRepository implements ConversationRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcConversationRepository.class);

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcConversationRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void deleteTable() {
        String sql1 = "drop temporary table if exists conversationIds";
        String sql2 = "create temporary table conversationIds(idConversation bigint(20) unsigned)";
        String sql3 = "insert into conversationIds (select c.id from conversation as c " +
            "where c.status='closed' and last_activity < DATE_SUB(NOW(), INTERVAL 12 MONTH))";
        String sql4 = "select count(*) from conversationIds";

        String sql5 = "SET autocommit=0";

        String sql6 = "delete chat.* from chat " +
            "inner join conversationIds on chat.conversation_id = conversationIds.idConversation";
        String sql7 = "delete conversation_detail.* from conversation_detail " +
            "inner join conversationIds on conversation_detail.conversation_id = conversationIds.idConversation";
        String sql8 = "delete conversation_extra_field.* from conversation_extra_field " +
            "inner join conversationIds on conversation_extra_field.conversation_id = conversationIds.idConversation";
        String sql9 = "delete conversation_label.* from conversation_label " +
            "inner join conversationIds on conversation_label.conversation_labels_id = conversationIds.idConversation";
        String sql10 = "delete contact_many_message.* from contact_many_message " +
            "inner join conversationIds on contact_many_message.conversation_id = conversationIds.idConversation";
        String sql11 = "delete conversation.* from conversation " +
            "inner join conversationIds on conversation.id = conversationIds.idConversation";
        String sql12 = "commit";

        int[] updateCounts = jdbc.batchUpdate(sql1, sql2, sql3, sql4, sql5, sql6, sql7, sql8, sql9, sql10, sql11, sql12);

        log.info("---> Number Of Conversation Rows Affected: " + updateCounts[2]);
    }
}
