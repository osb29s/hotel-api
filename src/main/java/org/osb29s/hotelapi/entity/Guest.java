package org.osb29s.hotelapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

/**
 * Guest, who books. Contains list of bookings and group, guest belongs to.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@Entity
@Table(name = "guests")
public class Guest extends Account {

  @Exclude
  @OneToMany(mappedBy = "bookedBy", cascade = CascadeType.ALL)
  private final List<Booking> bookings = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "group_id")
  private GuestGroup group;

  public Guest(GuestGroup group) {
    this.group = group;
  }

  @Builder
  public Guest(Long id, String phoneNumber, String fullName, LocalDateTime createdAt,
      LocalDateTime lastUpdatedAt, GuestGroup group) {
    super(id, phoneNumber, fullName, createdAt, lastUpdatedAt);
    this.group = group;
  }

  public void addBooking(Booking booking) {
    bookings.add(booking);
    booking.setBookedBy(this);
  }

  public void removeBooking(Booking booking) {
    bookings.remove(booking);
    booking.setBookedBy(null);
  }

}
