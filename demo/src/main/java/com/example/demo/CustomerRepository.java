package com.example.demo;

import com.example.demo.domain.CustomerEntity;
import org.hibernate.query.spi.QueryParameterBindingTypeResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
