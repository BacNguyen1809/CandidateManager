/*
	* @author bacng
	* @ Date Aug 23, 2022
*/
package fa.training.dao;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.entities.Interview;
import fa.training.utils.HQLCommand;
import fa.training.utils.HibernateUtils;

public class InterviewDaoImpl implements InterviewDao {

	public boolean save(Interview interview) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(interview);

			transaction.commit();
			return (result != null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Interview> findAll() throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<Interview> query = session.createQuery(HQLCommand.FIND_ALL_INTERVIEW);
							
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Integer update(Interview interview, int id) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query<Interview> query = session
					.createQuery(HQLCommand.UPDATE_INTERVIEW);
			query.setParameter("time", interview.getTime());
			query.setParameter("date", interview.getDate());
			query.setParameter("interviewer", interview.getInterviewer());
			query.setParameter("comments", interview.getComments());
			query.setParameter("interviewResutl", interview.getInterviewResutl());
			query.setParameter("remark", interview.getRemark());
			query.setParameter("candidate", interview.getCandidate());
			query.setParameter("interviewId", id);

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

			Interview load = session.load(Interview.class, id);
			if (load != null) {
				session.delete(load);
				session.getTransaction().commit();
				return true;
			}
			return false;

		} 

	}

	@Override
	public Interview findById(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<Interview> query = session.createQuery(HQLCommand.FIND_INTERVIEW_BY_ID);
			query.setParameter("interviewId", id);
			return query.getSingleResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}



}
