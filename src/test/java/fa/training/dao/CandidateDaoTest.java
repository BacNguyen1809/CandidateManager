/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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


public class CandidateDaoTest {
	static CandidateDao candidateDao;

	@BeforeAll

	static void setUpBeforeClass() throws Exception {
		candidateDao = new CandidateDaoImpl();
	}

	@Test
//	@Disabled
	void testSave1() throws Exception {
		Candidate candidate = new Candidate("full name", LocalDate.parse("1996-06-12"),1,
				LocalDate.parse("2022-06-12"), "03315654", "email1@gmail.com", "Skill 1", "language 1", 1, "string", 0,
				"remark 1");

		assertEquals(true, candidateDao.save(candidate));
	}
	
	

	@Test
//	@Disabled
	void testSave2() throws Exception {
		Candidate candidate = new Candidate("full name", LocalDate.parse("1996-06-12"),1,
				LocalDate.parse("2022-06-12"), "033153654", "email2@gmail.com", "Skill 2", "language 2", 2, "string", 0,
				"remark 2");

		assertEquals(true, candidateDao.save(candidate));
	}

	@Test
//	@Disabled
	void testSave3() throws Exception {
		Candidate candidate = new Candidate("full name", LocalDate.parse("1996-06-12"),0,
				LocalDate.parse("2022-06-12"), "0331253654", "email3@gmail.com", "Skill 3", "language 3", 3, "string", 0,
				null);

		assertEquals(true, candidateDao.save(candidate));
	}

	@Test
//	@Disabled
	void testFindAll() throws Exception {
		List<Candidate> findAll = candidateDao.findAll();
		assertEquals(true, findAll.size()>0);
	}

	@Test
//	@Disabled
	void testFindById() throws Exception {
		Candidate findById = candidateDao.findById(1);
		assertEquals(1, findById.getCandidateId());
	}
	
	@Test
//	@Disabled
	void testFindWithPaging() throws Exception {
		List<Candidate> findAll = candidateDao.findWithPaging(0,2);
		assertEquals(true, findAll.size()>0);

	}


	@Test
//	@Disabled
	void testFindBySkillAndLevel() throws Exception {
		List<Candidate> findBySkillAndLevel = candidateDao.findBySkillAndLevel("Skill 1", 1);

	}

	@Test
//	@Disabled
	void testFindBySkillAndForeignLanguage() throws Exception {
		List<Candidate> findBySkillAndLanguage = candidateDao.findByForeignLanguageAndSkill("language 1", "Skill 1");
		assertEquals(true, findBySkillAndLanguage.size()>0);

	}

	@Test
//	@Disabled
	void testFindBySkillAndResultTest() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = sdf.parse("15-Oct-2002");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(date);
		System.out.println(format);
		List<Object[]> test = candidateDao.findCandidatebySkillAndResultTest("Skill 1", "pass", LocalDate.parse(format));

		assertEquals(true, test.size()>0);

	}
	
	@Test
//	@Disabled
	void testFindByInterviewResult() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = sdf.parse("15-Oct-2022");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(date);
		System.out.println(format);
		List<Object[]> test = candidateDao.findCandidateByInterviewResult("pass", LocalDate.parse(format));
		assertEquals(true, test.size()>0);

	}

	@Test
//	@Disabled
	void testUpdate() throws Exception {
		Candidate candidate = new Candidate("full name", LocalDate.parse("1996-06-12"), 0,
				LocalDate.parse("2022-06-12"), "03315654", "email4@gmail.com", "Skill 4", "language 3", 5, null, 0,
				"remark 4");
		Integer update = candidateDao.update(candidate, 2);
		assertEquals(true, (update > 0));
	}
	
	@Test
//	@Disabled
	void testUpdateRemark() throws Exception {
		Integer update = candidateDao.updateRemark("update remark");
		assertEquals(true, (update > 0));
	}


	
	@Test
//	@Disabled
	void testNotNull() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Candidate candidate = new Candidate(null, null, 0,
				null, null, null, "Skill 4", "language 3", 5, "string", 0,
				"remark 4");
		
		Set<ConstraintViolation<Candidate>> constraintViolations = validator.validate(candidate);
		
		
		assertEquals(5, constraintViolations.size());
	}
	
	@Test
//	@Disabled
	void testGender() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		int gender = 3;
		Validator validator = factory.getValidator();
		Candidate candidate = new Candidate("full name", LocalDate.parse("1996-06-12"),gender,
				LocalDate.parse("2022-06-12"), "033153654", "email2@gmail.com", "Skill 2", "language 2", 2, "string", 0,
				"remark 2");
		
		Set<ConstraintViolation<Candidate>> constraintViolations = validator.validate(candidate);

		
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
//	@Disabled
	void testLevelGreaterSeven() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		int level =8;
		Validator validator = factory.getValidator();
		Candidate candidate = new Candidate("full name", LocalDate.parse("1996-06-12"),0,
				LocalDate.parse("2022-06-12"), "033153654", "email2@gmail.com", "Skill 2", "language 2", level, "string", 0,
				"remark 2");
		
		Set<ConstraintViolation<Candidate>> constraintViolations = validator.validate(candidate);

		
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
//	@Disabled
	void testLevelLowerOne() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		int level =-8;
		Validator validator = factory.getValidator();
		Candidate candidate = new Candidate("full name", LocalDate.parse("1996-06-12"),0,
				LocalDate.parse("2022-06-12"), "033153654", "email2@gmail.com", "Skill 2", "language 2", level, "string", 0,
				"remark 2");
		
		Set<ConstraintViolation<Candidate>> constraintViolations = validator.validate(candidate);

		
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	@Disabled
	void testDelete() throws Exception {
		boolean delete = candidateDao.delete(3);
		assertEquals(true, delete);
	}
	
	
	

}
