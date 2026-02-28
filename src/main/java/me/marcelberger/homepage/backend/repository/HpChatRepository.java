package me.marcelberger.homepage.backend.repository;

import me.marcelberger.homepage.backend.entity.HpChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HpChatRepository extends JpaRepository<HpChatEntity, Long> {
    List<HpChatEntity> findByLastActivityTimeUtcBefore(LocalDateTime threshold);
}
