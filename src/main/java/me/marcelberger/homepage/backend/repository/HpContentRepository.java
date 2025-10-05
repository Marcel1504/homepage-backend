package me.marcelberger.homepage.backend.repository;

import me.marcelberger.homepage.backend.entity.HpContentEntity;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HpContentRepository extends JpaRepository<HpContentEntity, Long> {
    Optional<HpContentEntity> findFirstByTypeAndLanguageOrderByVersionDateDesc(HpContentTypeEnum type, String language);
}
