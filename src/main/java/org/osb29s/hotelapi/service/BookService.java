package org.osb29s.hotelapi.service;

import java.util.ArrayList;
import java.util.List;
import org.osb29s.hotelapi.dto.AccDTO;
import org.osb29s.hotelapi.entity.Account;

public class AccServiceImpl implements AccService{

  private List<AccDTO> accList= new ArrayList<>();

  @Override
  public AccDTO findById(Long id) {
    return null;
  }

  @Override
  public List<AccDTO> findAll() {
    return null;
  }

  @Override
  public AccDTO addAcc(AccDTO acc) {
    Account account =
  }

  @Override
  public AccDTO updateAcc(Long id, AccDTO acc) {
    return null;
  }

  @Override
  public void removeAcc(Long id) {

  }
}
