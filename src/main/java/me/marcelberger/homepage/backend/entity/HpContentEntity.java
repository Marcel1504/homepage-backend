package me.marcelberger.homepage.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "content")
public class HpContentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version_date", nullable = false)
    private LocalDate versionDate;

    @Column(name = "type", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private HpContentTypeEnum type;

    @Column(name = "language", length = 2, nullable = false)
    private String language;

    @Column(name = "data", columnDefinition = "JSON", nullable = false)
    private String data;
}
