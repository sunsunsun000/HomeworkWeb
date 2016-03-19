package me.hupeng.homeworkweb.DAO;

import java.util.List;

import me.hupeng.homeworkweb.bean.Homework;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Homework entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see me.hupeng.homeworkweb.bean.Homework
 * @author MyEclipse Persistence Tools
 */
public class HomeworkDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HomeworkDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String SUBMIT_TIME = "submitTime";
	public static final String TASK_ID = "taskId";
	public static final String PATH = "path";
	public static final String GRADE = "grade";

	public void save(Homework transientInstance) {
		log.debug("saving Homework instance");
		Transaction transaction= getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			getSession().saveOrUpdate(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		transaction.commit();  
		//getSession().flush();  
		getSession().close();
	}

	public void delete(Homework persistentInstance) {
		log.debug("deleting Homework instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Homework findById(java.lang.Integer id) {
		log.debug("getting Homework instance with id: " + id);
		try {
			Homework instance = (Homework) getSession().get(
					"me.hupeng.homeworkweb.bean.Homework", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Homework instance) {
		log.debug("finding Homework instance by example");
		try {
			List results = getSession()
					.createCriteria("me.hupeng.homeworkweb.bean.Homework")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		getSession().clear();
		log.debug("finding Homework instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Homework as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findBySubmitTime(Object submitTime) {
		return findByProperty(SUBMIT_TIME, submitTime);
	}

	public List findByTaskId(Object taskId) {
		return findByProperty(TASK_ID, taskId);
	}

	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List findByGrade(Object grade) {
		return findByProperty(GRADE, grade);
	}

	public List findAll() {
		log.debug("finding all Homework instances");
		try {
			String queryString = "from Homework";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Homework merge(Homework detachedInstance) {
		log.debug("merging Homework instance");
		try {
			Homework result = (Homework) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Homework instance) {
		log.debug("attaching dirty Homework instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Homework instance) {
		log.debug("attaching clean Homework instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}