package me.hupeng.homeworkweb.DAO;

import java.util.List;

import me.hupeng.homeworkweb.bean.Bug;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Bug
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see me.hupeng.homeworkweb.bean.Bug
 * @author MyEclipse Persistence Tools
 */
public class BugDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BugDAO.class);
	// property constants
	public static final String TIME = "time";
	public static final String USER_ID = "userId";
	public static final String EMAIL = "email";
	public static final String TEXT = "text";
	public static final String STATUS = "status";

	public void save(Bug transientInstance) {
		log.debug("saving Bug instance");
		Transaction transaction= getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		transaction.commit();  
		getSession().flush();  
		getSession().close();
	}

	public void delete(Bug persistentInstance) {
		log.debug("deleting Bug instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bug findById(java.lang.Integer id) {
		log.debug("getting Bug instance with id: " + id);
		try {
			Bug instance = (Bug) getSession().get(
					"me.hupeng.homeworkweb.bean.Bug", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bug instance) {
		log.debug("finding Bug instance by example");
		try {
			List results = getSession()
					.createCriteria("me.hupeng.homeworkweb.bean.Bug")
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
		log.debug("finding Bug instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bug as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Bug instances");
		try {
			String queryString = "from Bug";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bug merge(Bug detachedInstance) {
		log.debug("merging Bug instance");
		try {
			Bug result = (Bug) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bug instance) {
		log.debug("attaching dirty Bug instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bug instance) {
		log.debug("attaching clean Bug instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}