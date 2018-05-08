package com.isep.cardis.projet_fiches_module_A2.sheet;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SheetRepository extends CrudRepository<Sheet, Integer> {
	List<Sheet> findByIsPublished(boolean statut);
	Optional<Sheet> findById(Integer id);
}
