package com.puzan.springhandson.repository;

import com.puzan.springhandson.model.DocSetting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocSettingRepository extends JpaRepository<DocSetting, Long> {
    
}
