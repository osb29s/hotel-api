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
import org.hibernate.annotations.NaturalId;

/**
 * General entity, which describes any user of the system.
 * Uses phone number as a natural id.
 * In future may store another info, like statistics password, etc.
 */
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
  protected Long id;

  @Column(nullable = false)
  @NaturalId
  @Pattern(regexp = "\\+(\\d{1,2}) \\(\\d{3}\\)-\\d{3}-\\d{4}",
      message = "Wrong phone number format")
  protected String phoneNumber;

  @Column(nullable = false)
  @Size(min = 3, max = 128, message = "Full name should be between 3 and 128 characters")
  protected String fullName;

  protected LocalDateTime createdAt = LocalDateTime.now();
  protected LocalDateTime lastUpdatedAt = LocalDateTime.now();

}
