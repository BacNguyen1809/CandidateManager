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
import fa.training.utils.HQLCommand;
import fa.training.utils.HibernateUtils;

public class EntryTestDaoImpl implements EntryTestDao {

	public boolean save(EntryTest entryTest) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(entryTest);

			transaction.commit();
			return (result != null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<EntryTest> findAll() throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<EntryTest> query = session.createQuery(HQLCommand.FIND_ALL_ENTRY_TEST);
								
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Integer update(EntryTest entryTest, int id) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query<EntryTest> query = session
					.createQuery(HQLCommand.UPDATE_ENTRY_TEST);
			query.setParameter("time", entryTest.getTime());
			query.setParameter("date", entryTest.getDate());
			query.setParameter("languageValuator", entryTest.getLanguageValuator());
			query.setParameter("languageResult", entryTest.getLanguageResult());
			query.setParameter("technicalValuator", entryTest.getTechnicalValuator());
			query.setParameter("result", entryTest.getResult());
			query.setParameter("entryTestSkill", entryTest.getEntryTestSkill());
			query.setParameter("remark", entryTest.getRemark());
			query.setParameter("candidate", entryTest.getCandidate());
			query.setParameter("testId", id);

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

			EntryTest load = session.load(EntryTest.class, id);
			if (load != null) {
				session.delete(load);
				session.getTransaction().commit();
				return true;
			}
			return false;

		} 

	}

	@Override
	public EntryTest findById(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<EntryTest> query = session.createQuery(HQLCommand.FIND_BY_ENTRY_TEST_ID);
			query.setParameter("testId", id);
			return query.getSingleResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}



}
