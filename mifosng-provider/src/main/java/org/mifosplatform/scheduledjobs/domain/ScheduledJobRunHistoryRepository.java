package org.mifosplatform.scheduledjobs.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduledJobRunHistoryRepository extends JpaRepository<ScheduledJobRunHistory, Long>,
        JpaSpecificationExecutor<ScheduledJobRunHistory> {

    @Query("select max(sjrh.version) from ScheduledJobRunHistory sjrh where sjrh.scheduledJobDetails.triggerKey = :triggerKey")
    Long findMaxVersionByTriggerKey(@Param("triggerKey") String triggerKey);

}
