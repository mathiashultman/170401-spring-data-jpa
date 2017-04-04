package biz.mathias.db;

import org.springframework.data.repository.CrudRepository;

import biz.mathias.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	// @Query("SELECT t.title FROM Todo t where t.id = :id")
	// String findTitleById(@Param("id") Long id);
	//
	// @Query("SELECT t.title FROM Todo t where t.id = :id")
	// Optional<String> findTitleById(@Param("id") Long id);
	//
	// Todo findById(Long id);
	//
	// Optional<Todo> findById(Long id);
	//
	// List<Todo> findByTitle(String title);
}
