package com.thuexe.reponsitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thuexe.entity.ThuexeEntity;

@Repository
public interface ThuexeReponsitory extends JpaRepository<ThuexeEntity, Integer>{


}
