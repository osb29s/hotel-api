package org.osb29s.hotelapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.osb29s.hotelapi.entity.GuestGroup;

@Data
@AllArgsConstructor
public class GuestDto {
  private Long id;
  private String phoneNumber;
  private String fullName;
  private LocalDateTime createdAt;
  private LocalDateTime lastUpdatedAt;
  private List<Long> bookingIds;
  private GuestGroup group;
}
