package com.isep.cardis.projet_fiches_module_A2.hour;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface HourRepository extends CrudRepository<Hour, Integer> {

	Optional<Hour> findById(Integer id);
}
