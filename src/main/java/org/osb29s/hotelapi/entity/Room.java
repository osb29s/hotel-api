package org.osb29s.hotelapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.osb29s.hotelapi.entity.enumeration.RoomState;

/**
 * Hotel room. Contains type, list of bookings, state, number, floor and position on floor
 * and optional price and description. If price is not specified, it should be as "check by phone".
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms", uniqueConstraints = {
    @UniqueConstraint(name = "room_number_uk", columnNames = "number")
})
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "room_type_id")
  private RoomType roomType;

  @Exclude
  @ManyToMany
  private final List<Booking> bookings = new ArrayList<>();

  @Enumerated
  @Builder.Default
  @NotNull(message = "Room state must be specified")
  @Column(nullable = false)
  private RoomState roomState = RoomState.AVAILABLE;

  @NotNull(message = "Room number must be specified")
  @Column(nullable = false)
  private Short number;

  /**
   * Describes position, which a room has on a floor. May be useful for UI implementation.
   */
  @NotNull(message = "Room position must be specified")
  @Column(nullable = false)
  private Short position;

  @NotNull(message = "Room floor must be specified")
  @Column(nullable = false)
  private Short floor;

  private BigDecimal price;

  private String description;

}
