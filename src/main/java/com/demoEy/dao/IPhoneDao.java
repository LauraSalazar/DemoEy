package com.demoEy.dao;

import com.demoEy.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface IPhoneDao extends CrudRepository<Phone, Long> {
}
