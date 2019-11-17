package com.btvn.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.btvn.model.SvEntity;

@Repository
public interface SvReponsitory extends JpaRepository<SvEntity, Integer>,QueryByExampleExecutor<SvEntity>{

//	@Query(value ="SELECT e FROM Customer e WHERE e.name = ?1", nativeQuery = true)
	List<SvEntity> findByName(String name);

	SvEntity deleteByname(String name);


}
