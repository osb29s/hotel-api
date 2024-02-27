package org.osb29s.hotelapi.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomTypeDto {
  private Long id;
  private List<Long> roomIds;
  private String name;
  private String description;
}
