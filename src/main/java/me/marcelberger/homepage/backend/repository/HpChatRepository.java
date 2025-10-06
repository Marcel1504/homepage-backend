package me.marcelberger.homepage.backend.repository;

import me.marcelberger.homepage.backend.entity.HpChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HpChatRepository extends JpaRepository<HpChatEntity, Long> {
}
