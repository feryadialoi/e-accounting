package com.example.eaccounting.entity;

import com.example.eaccounting.entity.enums.NormalBalance;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 12/16/2021 12:09 AM
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coas")
@EntityListeners(AuditingEntityListener.class)
public class Coa {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "normal_balance", columnDefinition = "enum('DEBIT', 'CREDIT')")
    private NormalBalance normalBalance;


    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "timestamp(3)")
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "timestamp(3)")
    private LocalDateTime updatedAt;
}
