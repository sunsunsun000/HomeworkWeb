package me.hupeng.homeworkweb.DAO;

import java.util.List;

import me.hupeng.homeworkweb.bean.Choiceclass;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Choiceclass entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see me.hupeng.homeworkweb.bean.Choiceclass
 * @author MyEclipse Persistence Tools
 */
public class ChoiceclassDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ChoiceclassDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String CLASS_ID = "classId";

	public void save(Choiceclass transientInstance) {
		log.debug("saving Choiceclass instance");
//		Transaction transaction= getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
//		transaction.commit();  
//		getSession().flush(); 
//		getSession().close();
	}

	public void delete(Choiceclass persistentInstance) {
		log.debug("deleting Choiceclass instance");
		Transaction transaction= getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		transaction.commit();  
	}

	public Choiceclass findById(java.lang.Integer id) {
		log.debug("getting Choiceclass instance with id: " + id);
		try {
			Choiceclass instance = (Choiceclass) getSession().get(
					"me.hupeng.homeworkweb.bean.Choiceclass", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Choiceclass instance) {
		log.debug("finding Choiceclass instance by example");
		try {
			List results = getSession()
					.createCriteria("me.hupeng.homeworkweb.bean.Choiceclass")
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
		log.debug("finding Choiceclass instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Choiceclass as model where model."
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

	public List findByClassId(Object classId) {
		return findByProperty(CLASS_ID, classId);
	}

	public List findAll() {
		log.debug("finding all Choiceclass instances");
		try {
			String queryString = "from Choiceclass";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Choiceclass merge(Choiceclass detachedInstance) {
		log.debug("merging Choiceclass instance");
		try {
			Choiceclass result = (Choiceclass) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Choiceclass instance) {
		log.debug("attaching dirty Choiceclass instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Choiceclass instance) {
		log.debug("attaching clean Choiceclass instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}