package ch.hearc.holygram.repositories;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Evaluation;

/**
 * Documentation :
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface EvaluationRepository extends CrudRepository<Evaluation, Long> {

}
