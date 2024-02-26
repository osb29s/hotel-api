package org.osb29s.hotelapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

/**
 * Unites guests into a group. May be useful, if same group of people makes a booking from
 * different phone numbers. In that case, we can join them into single group, which may be useful
 * for better coordination and statistics.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guest_groups")
public class GuestGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Exclude
  @Setter(AccessLevel.PRIVATE)
  @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
  private List<Guest> guests;

  private String description;

}
