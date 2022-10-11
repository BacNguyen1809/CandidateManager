/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import fa.training.entities.Candidate;


public interface CandidateDao {
	
	boolean save(Candidate candidate) throws Exception;
	
	public List<Candidate> findAll() throws Exception; 
	
	public List<Candidate> findWithPaging(int firstResult, int maxResult) throws Exception; 
	
	public Candidate findById(int id) throws Exception; 
	
	Integer update(Candidate candidate, int id) throws Exception;
	
	Integer updateRemark(String remark) throws Exception;
	
	boolean delete(Serializable id) throws Exception;
	
	public List<Candidate> findBySkillAndLevel(String skill, Integer level) throws Exception; 
	
	public List<Candidate> findByForeignLanguageAndSkill(String foreignLanguage, String skill) throws Exception; 
	
	public List<Object[]> findCandidatebySkillAndResultTest(String skill, String result, LocalDate date ) throws Exception;

	public List<Object[]> findCandidateByInterviewResult(String interviewResutl, LocalDate date ) throws Exception;

}
