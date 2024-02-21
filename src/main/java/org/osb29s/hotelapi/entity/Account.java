package org.osb29s.hotelapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "accounts", uniqueConstraints = {
      @UniqueConstraint(name = "accounts_phone_uk", columnNames = "phone_number")
    })
public class Account {

  @Id
  private Long id;

  @Column(nullable = false)
  @Pattern(regexp = "\\+(\\d{1,2}) \\(\\d{3}\\)-\\d{3}-\\d{4}",
      message = "Wrong phone number format")
  String phoneNumber;

  @Column(nullable = false)
  @Size(min = 3, max = 128, message = "Full name should be between 3 and 128 characters")
  String fullName;

  LocalDateTime createdAt = LocalDateTime.now();
  LocalDateTime lastUpdatedAt = LocalDateTime.now();
  // TODO: LDT createdBy, lastUpdatedBy, which are FKs for managers who created/updated account

}
