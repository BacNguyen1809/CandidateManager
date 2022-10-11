/*
	* @author bacng
	* @ Date Aug 23, 2022
*/
package fa.training.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Candidate;
import fa.training.utils.HQLCommand;
import fa.training.utils.HibernateUtils;

public class CandidateDaoImpl implements CandidateDao {

	public boolean save(Candidate candidate) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(candidate);

			transaction.commit();
			return (result != null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Candidate> findAll() throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<Candidate> query = session.createQuery(HQLCommand.FIND_ALL_CANDIDATE);
								
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List<Candidate> findWithPaging(int firstResult, int maxResult) throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<Candidate> query = session.createQuery(HQLCommand.FIND_ALL_CANDIDATE);
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Integer update(Candidate candidate, int id) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query<Candidate> query = session
					.createQuery(HQLCommand.UPDATE_CANDIDATE);
			query.setParameter("fullName", candidate.getFullName());
			query.setParameter("dateOfBirth", candidate.getDateOfBirth());
			query.setParameter("gender", candidate.getGender());
			query.setParameter("graduationYear", candidate.getGraduationYear());
			query.setParameter("phone", candidate.getPhone());
			query.setParameter("email", candidate.getEmail());
			query.setParameter("skill", candidate.getSkill());
			query.setParameter("foreignLanguage", candidate.getForeignLanguage());
			query.setParameter("level", candidate.getLevel());
			query.setParameter("cv", candidate.getCv());
			query.setParameter("allocationStatus", candidate.getAllocationStatus());
			query.setParameter("remark", candidate.getRemark());
			query.setParameter("candidateId", id);

			int result = query.executeUpdate();
			transaction.commit();
			return result;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	public Integer updateRemark(String remark) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query<Candidate> query = session
					.createQuery(HQLCommand.UPDATE_CANDIDATE_REMARK);
			query.setParameter("remark", remark);
			int result = query.executeUpdate();
			transaction.commit();
			return result;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	


	public boolean delete(Serializable id) throws Exception {

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.beginTransaction();

			Candidate load = session.load(Candidate.class, id);
			if (load != null) {
				session.delete(load);
				session.getTransaction().commit();
				return true;
			}
			return false;

		} 

	}

	@Override
	public Candidate findById(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<Candidate> query = session.createQuery(HQLCommand.FIND_BY_CANDIDATE_ID);
			query.setParameter("candidateId", id);
			return query.getSingleResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Candidate> findBySkillAndLevel(String skill, Integer level) throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<Candidate> query = session.createQuery(HQLCommand.FIND_BY_CANDIDATE_BY_SKILL_AND_LEVEL);
			query.setParameter("skill", skill);
			query.setParameter("level", level);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Candidate> findByForeignLanguageAndSkill(String foreignLanguage, String skill) throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<Candidate> query = session.createQuery(HQLCommand.FIND_BY_CANDIDATE_BY_SKILL_AND_FOREIGN_LANGUAGE);
			query.setParameter("skill", skill);
			query.setParameter("foreignLanguage", foreignLanguage);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Object[]> findCandidatebySkillAndResultTest(String skill, String result,LocalDate date) throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query query = session.createQuery(HQLCommand.FIND_BY_CANDIDATE_BY_SKILL_AND_ENTRY_TEST_RESULT);
			query.setParameter("skill", skill);
			query.setParameter("result", result);
			query.setParameter("date", date);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Object[]> findCandidateByInterviewResult(String interviewResutl, LocalDate date)
			throws Exception {
		
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query query = session.createQuery(HQLCommand.FIND_BY_CANDIDATE_BY_INTERVIWER_RESULT);
			query.setParameter("date", date);
			query.setParameter("interviewResutl", interviewResutl);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}



}
