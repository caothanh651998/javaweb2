package com.Function.APIdata;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface sinhVienDAO extends JpaRepository<sinhVien, Integer> {

}