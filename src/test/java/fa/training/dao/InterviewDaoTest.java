/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import fa.training.entities.Candidate;
import fa.training.entities.Interview;

public class InterviewDaoTest {
	static InterviewDao interviewDao;
	static CandidateDao candidateDao;

	@BeforeAll

	static void setUpBeforeClass() throws Exception {
		interviewDao = new InterviewDaoImpl();
		candidateDao = new CandidateDaoImpl();
	}

	@Test
//	@Disabled
	void testSave1() throws Exception {
		Interview interview = new Interview("time", LocalDate.parse("2022-10-15"), "interviewer", "comment", "pass",
				"remark");
		Candidate candidate = candidateDao.findById(1);
		interview.setCandidate(candidate);

		assertEquals(true, interviewDao.save(interview));
	}

	@Test
//	@Disabled
	void testSave2() throws Exception {
		Interview interview = new Interview("time", LocalDate.parse("2022-10-15"), "interviewer", "comment", "fail",
				"remark");
		Candidate candidate = candidateDao.findById(1);
		interview.setCandidate(candidate);

		assertEquals(true, interviewDao.save(interview));
	}

	@Test
//	@Disabled
	void testSave3() throws Exception {
		Interview interview = new Interview("time", LocalDate.parse("2022-06-03"), "interviewer", "comment", "pass",
				"remark");
		Candidate candidate = candidateDao.findById(2);
		interview.setCandidate(candidate);


		assertEquals(true, interviewDao.save(interview));
	}

	@Test
	@Disabled
	void testFindAll() throws Exception {
		List<Interview> findAll = interviewDao.findAll();
		for (Interview entryTest : findAll) {
			System.out.println(entryTest);
		}
	}

	@Test
	@Disabled
	void testFindById() throws Exception {
		Interview findById = interviewDao.findById(1);
		System.out.println(findById);
	}

	@Test
	@Disabled
	void testUpdate() throws Exception {
		Interview interview = new Interview("time", LocalDate.parse("2022-10-15"), "interviewer", "comment", "fail",
				"remark");
		Candidate candidate = candidateDao.findById(3);
		interview.setCandidate(candidate);


		Integer update = interviewDao.update(interview, 2);

		assertEquals(true, (update > 0));
	}

	@Test
	@Disabled
	void testDelete() throws Exception {
		boolean delete = interviewDao.delete(1);
		assertEquals(true, delete);
	}

}
