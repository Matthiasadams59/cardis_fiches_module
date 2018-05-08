package com.isep.cardis.projet_fiches_module_A2.information;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.isep.cardis.projet_fiches_module_A2.user.User;

public interface InformationRepository extends CrudRepository<Information, Integer>{
	
	Optional<Information> findById(Integer id);
	Information findByUser(User user);
	List<Information> findByUserId(Integer userId);

}
