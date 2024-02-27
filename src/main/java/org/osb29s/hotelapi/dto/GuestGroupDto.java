package org.osb29s.hotelapi.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuestGroupDto {
  private Long id;
  private List<Long> guestIds;
  private String description;
}
