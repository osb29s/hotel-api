package org.osb29s.hotelapi.mapper;

import org.osb29s.hotelapi.dto.AccDTO;
import org.osb29s.hotelapi.entity.Booking;

public class AccMapperImpl implements AccMapper{

  @Override
  public AccDTO dtoToAcc(Booking acc) {
    return new AccDTO(acc.getId(), acc.getFullName(), acc.getPhoneNumber());
  }

  @Override
  public Booking AccToDto(AccDTO acc) {
    Booking newAcc = new Booking();
    newAcc.setId(acc.getId());
    newAcc.setFullName(acc.getFullName());
    newAcc.setPhoneNumber(acc.getPhoneNumber());
    return newAcc;
  }
}
