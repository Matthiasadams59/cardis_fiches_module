package com.isep.cardis.projet_fiches_module_A2.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
	void deleteByUsername(String username);
}
