package org.osb29s.hotelapi.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.osb29s.hotelapi.entity.RoomType;
import org.osb29s.hotelapi.entity.enumeration.RoomState;

@Data
@AllArgsConstructor
public class RoomDto {
  private Long id;
  private RoomType roomType;
  private List<Long> bookingIds;
  private RoomState roomState = RoomState.AVAILABLE;
  private Short number;
  private Short position;
  private Short floor;
  private BigDecimal price;
  private String description;
}
