package org.osb29s.hotelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class AccDTO {
private long id;
private String fullName;
private String phoneNumber;

}
