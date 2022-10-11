/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.dao;

import java.io.Serializable;
import java.util.List;


import fa.training.entities.Interview;


public interface InterviewDao {
	
	boolean save(Interview interview) throws Exception;
	
	public List<Interview> findAll() throws Exception; 
	
	public Interview findById(int id) throws Exception; 
	
	Integer update(Interview interview, int id) throws Exception;
	
	boolean delete(Serializable id) throws Exception;

}
