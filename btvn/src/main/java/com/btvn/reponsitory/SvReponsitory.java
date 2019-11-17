package com.btvn.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btvn.model.SvEntity;

public interface SvReponsitory extends JpaRepository<SvEntity, Integer>{

//	List<SvEntity> findByName(String name);

}
