/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;

public class EntryTestDaoTest {
	static EntryTestDao entryTestDao;
	static CandidateDao candidateDao;

	@BeforeAll

	static void setUpBeforeClass() throws Exception {
		entryTestDao = new EntryTestDaoImpl();
		candidateDao = new CandidateDaoImpl();
	}

	@Test
//	@Disabled
	void testSave1() throws Exception {
		EntryTest entryTest = new EntryTest("time", LocalDate.parse("2002-10-15"), "language 1", new BigDecimal("5.5"),
				"String", "pass", "entry skill", "renmark",new BigDecimal("6.5"));
		Candidate candidate = candidateDao.findById(1);
		entryTest.setCandidate(candidate);

		assertEquals(true, entryTestDao.save(entryTest));
	}

	@Test
//	@Disabled
	void testSave2() throws Exception {
		EntryTest entryTest = new EntryTest("time", LocalDate.parse("2002-10-16"), "language 2", new BigDecimal("7.5"),
				"String", "fail", "entry skill", "renmark", new BigDecimal("8.5"));
		Candidate candidate = candidateDao.findById(1);
		entryTest.setCandidate(candidate);

		assertEquals(true, entryTestDao.save(entryTest));
	}

	@Test
//	@Disabled
	void testSave3() throws Exception {
		EntryTest entryTest = new EntryTest("time", LocalDate.parse("2002-10-17"), "language 3", new BigDecimal("7"),
				"String", "pass", "entry skill", "renmark", new BigDecimal("2"));
		Candidate candidate = candidateDao.findById(3);
		entryTest.setCandidate(candidate);

		assertEquals(true, entryTestDao.save(entryTest));
	}

	@Test
	@Disabled
	void testFindAll() throws Exception {
		List<EntryTest> findAll = entryTestDao.findAll();
		assertEquals(true, findAll.size()>0);
	}

	@Test
	@Disabled
	void testFindById() throws Exception {
		EntryTest findById = entryTestDao.findById(1);
		assertNotNull(findById);
	}

	@Test
	@Disabled
	void testUpdate() throws Exception {
		EntryTest entryTest = new EntryTest("time", LocalDate.parse("2002-06-05"), "language", new BigDecimal("5"),
				"String", "pass", "entry skill", "renmark", new BigDecimal("6"));
		Candidate candidate = candidateDao.findById(3);
		
		entryTest.setCandidate(candidate);
		
		Integer update = entryTestDao.update(entryTest, 2);

		assertEquals(true, (update > 0));
	}
	
	@Test
	@Disabled
	void testResult() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		EntryTest entryTest = new EntryTest("time", LocalDate.parse("2002-06-05"), "language", new BigDecimal("5"),
				"String", "result", "entry skill", "renmark", new BigDecimal("6"));
		Candidate candidate = candidateDao.findById(2);
		entryTest.setCandidate(candidate);
		
		Set<ConstraintViolation<EntryTest>> constraintViolations = validator.validate(entryTest);

		
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	@Disabled
	void testLaguageResultAndTechnicalResultGreaterTen() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		BigDecimal languageResult = new BigDecimal(11);
		BigDecimal technicalResult = new BigDecimal(11);
		Validator validator = factory.getValidator();
		EntryTest entryTest = new EntryTest("time", LocalDate.parse("2002-06-05"), "language", languageResult,
				"String", "pass", "entry skill", "renmark", technicalResult);
		Candidate candidate = candidateDao.findById(2);
		entryTest.setCandidate(candidate);
		Set<ConstraintViolation<EntryTest>> constraintViolations = validator.validate(entryTest);

		
		assertEquals(2, constraintViolations.size());
	}
	
	@Test
	@Disabled
	void testLaguageResultAndTechnicalResultSmallerZero() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		BigDecimal languageResult = new BigDecimal(-11);
		BigDecimal technicalResult = new BigDecimal(-11);
		Validator validator = factory.getValidator();
		EntryTest entryTest = new EntryTest("time", LocalDate.parse("2002-06-05"), "language", languageResult,
				"String", "pass", "entry skill", "renmark", technicalResult);
		Candidate candidate = candidateDao.findById(2);
		entryTest.setCandidate(candidate);
		Set<ConstraintViolation<EntryTest>> constraintViolations = validator.validate(entryTest);

		
		assertEquals(2, constraintViolations.size());
	}
	
	


	@Test
	@Disabled
	void testDelete() throws  Exception {
		boolean delete = entryTestDao.delete(3);
		assertEquals(true, delete);
	}

}
