package org.osb29s.hotelapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.osb29s.hotelapi.entity.enumeration.BookingState;

@Data
@AllArgsConstructor
public class BookDto {
  private Long id;
  private BookingState bookingState = BookingState.CREATED;
  private List<Long> roomIds;
  private Long bookedById;
  private Short guests;
  private LocalDateTime checkInTime;
  private LocalDateTime checkOutTime;
  private String description;

}
