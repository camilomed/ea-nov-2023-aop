package com.example.springdata.Repository;

import com.example.springdata.aspects.ActivityLog;
import org.hibernate.query.criteria.JpaCollectionJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog,Long> {
}
