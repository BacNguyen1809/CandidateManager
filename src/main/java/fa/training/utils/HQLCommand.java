/*
	* @author bacng
	* @ Date Aug 24, 2022
*/
package fa.training.utils;

public class HQLCommand {
	public static String FIND_ALL_CANDIDATE ="FROM Candidate";
	
	public static String FIND_BY_CANDIDATE_ID ="FROM Candidate \n"
						+ "WHERE candidateId = :candidateId ";
	
	public static String FIND_BY_CANDIDATE_BY_SKILL_AND_LEVEL ="FROM Candidate \n"
			+ "WHERE skill = :skill AND level = :level";
	
	public static String FIND_BY_CANDIDATE_BY_SKILL_AND_FOREIGN_LANGUAGE ="FROM Candidate \n"
			+ "WHERE skill = :skill AND foreignLanguage = :foreignLanguage";
	
	public static String FIND_BY_CANDIDATE_BY_SKILL_AND_ENTRY_TEST_RESULT ="FROM Candidate c JOIN c.entryTests et\n"
			+ "WHERE c.skill = :skill AND et.result = :result AND et.date = :date";
	
	public static String FIND_BY_CANDIDATE_BY_INTERVIWER_RESULT ="FROM Candidate c JOIN c.interviews et\n"
			+ "WHERE et.date = :date AND et.interviewResutl = :interviewResutl";
	
	public static String UPDATE_CANDIDATE_REMARK ="UPDATE Candidate \n" 
			+ "SET remark = :remark \n"
			+ "WHERE phone = null or email = null or cv = null";
	
	public static String UPDATE_CANDIDATE ="UPDATE Candidate \n" 
						+ "SET fullName = :fullName,"
						+ "dateOfBirth = :dateOfBirth,"
						+ "gender = :gender,"
						+ "graduationYear = :graduationYear,"
						+ "phone = :phone,"
						+ "email = :email,"
						+ "skill = :skill,"
						+ "foreignLanguage = :foreignLanguage,"
						+ "level = :level,"
						+ "cv = :cv,"
						+ "allocationStatus = :allocationStatus,"
						+ "remark = :remark \n"
						+ "WHERE candidateId = :candidateId";
	
	public static String FIND_ALL_ENTRY_TEST ="FROM EntryTest";
	
	public static String FIND_BY_ENTRY_TEST_ID ="FROM EntryTest\n"
						+ " WHERE testId = :testId";
	
	public static String UPDATE_ENTRY_TEST ="UPDATE EntryTest \n" 
						+ "SET time = :time,"
						+ "date = :date,"
						+ "languageValuator = :languageValuator,"
						+ "languageResult = :languageResult,"
						+ "technicalValuator = :technicalValuator,"
						+ "result = :result,"
						+ "entryTestSkill = :entryTestSkill,"
						+ "remark = :remark,"
						+ "candidate = :candidate\n"
						+ "WHERE testId = :testId";
	
	public static String FIND_ALL_INTERVIEW ="FROM Interview";
	
	public static String FIND_INTERVIEW_BY_ID ="FROM Interview"
			+ " WHERE interviewId = :interviewId";
			
	
	public static String UPDATE_INTERVIEW ="UPDATE Interview \n" 
						+ "SET time = :time,"
						+ "date = :date,"
						+ "interviewer = :interviewer,"
						+ "comments = :comments,"
						+ "interviewResutl = :interviewResutl,"
						+ "remark = :remark,"
						+ "candidate = :candidate\n"
						+ "WHERE interviewId = :interviewId";

//	public static String DELETE_MOVIE_TYPE_BY_MOVIE ="DELETE Interview"
//			+ " WHERE movie = :movie";
//			
}
