package com.andromeda.fintrack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.andromeda.fintrack.entity.CompanyMasterEntity;

@EnableJpaRepositories
public interface CompanyRepository extends JpaRepository<CompanyMasterEntity, Integer>{

}
