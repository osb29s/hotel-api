package org.osb29s.hotelapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.osb29s.hotelapi.entity.enumeration.BookingState;

/**
 * Describes booking of a room by a guest.
 * Contains booking state, list of rooms, which are booked, guest who created the booking,
 * expected number of people, check-in-out times, and optional description.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated
  @Builder.Default
  @NotNull(message = "Booking must have a state")
  @Column(nullable = false)
  private BookingState bookingState = BookingState.CREATED;

  @Setter(AccessLevel.PRIVATE)
  @Exclude
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "bookings_rooms",
      joinColumns = @JoinColumn(name = "booking_id"),
      inverseJoinColumns = @JoinColumn(name = "room_id"))
  @Size(min = 1, message = "At least 1 room should be reserved")
  private List<Room> rooms;

  @Exclude
  @NotNull(message = "Booking can't exist without guest")
  @ManyToOne
  @JoinColumn(name = "booked_by_id", nullable = false)
  private Guest bookedBy;

  @Size(min = 1, message = "At least 1 guest should arrive")
  @Column(nullable = false)
  private Short guests;

  @NotNull(message = "Check-in time must be specified")
  @Column(nullable = false)
  private LocalDateTime checkInTime;

  @NotNull(message = "Check-out time must be specified")
  @Column(nullable = false)
  private LocalDateTime checkOutTime;


  private String description;

}
