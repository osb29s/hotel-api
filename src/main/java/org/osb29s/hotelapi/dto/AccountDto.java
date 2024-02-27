package org.osb29s.hotelapi.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
  private Long id;
  private String phoneNumber;
  private String fullName;
  private LocalDateTime createdAt;
  private LocalDateTime lastUpdatedAt;
}
