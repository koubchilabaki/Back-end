package com.dosi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dosi.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	@Query(value="select count(*) from question where intitule = ?1", nativeQuery = true)
	int countIntituleQuestion(String intitule);
	
	@Query(value="\n" + 
			"select count(q.id_question) from question q,qualificatif ql, question_evaluation e where ql.id_qualificatif=q.id_qualificatif and q.id_question=e.id_question and q.id_question=?1\n" + 
			"", nativeQuery = true)
	int countQuestionQualificatifEvaluation(int idQuestion);
}
