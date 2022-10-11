/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.dao;

import java.io.Serializable;
import java.util.List;

import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;


public interface EntryTestDao {
	
	boolean save(EntryTest entryTest) throws Exception;
	
	public List<EntryTest> findAll() throws Exception; 
	
	public EntryTest findById(int id) throws Exception; 
	
	Integer update(EntryTest entryTest, int id) throws Exception;
	
	boolean delete(Serializable id) throws Exception;

}
