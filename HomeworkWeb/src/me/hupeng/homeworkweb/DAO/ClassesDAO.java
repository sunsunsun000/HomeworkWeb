package me.hupeng.homeworkweb.DAO;

import java.util.List;

import me.hupeng.homeworkweb.bean.Classes;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see me.hupeng.homeworkweb.bean.Classes
 * @author MyEclipse Persistence Tools
 */
public class ClassesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ClassesDAO.class);
	// property constants
	public static final String CLASS_NAME = "className";
	public static final String NOTICE = "notice";
	public static final String USER_ID = "userId";

	public void save(Classes transientInstance) {
		log.debug("saving Classes instance");
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

	public void delete(Classes persistentInstance) {
		log.debug("deleting Classes instance");
		Transaction transaction= getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		transaction.commit();  
		getSession().flush();  
		getSession().close();
	}

	public Classes findById(java.lang.Integer id) {
		log.debug("getting Classes instance with id: " + id);
		try {
			Classes instance = (Classes) getSession().get(
					"me.hupeng.homeworkweb.bean.Classes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Classes instance) {
		log.debug("finding Classes instance by example");
		try {
			List results = getSession()
					.createCriteria("me.hupeng.homeworkweb.bean.Classes")
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
		log.debug("finding Classes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClassName(Object className) {
		return findByProperty(CLASS_NAME, className);
	}

	public List findByNotice(Object notice) {
		return findByProperty(NOTICE, notice);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findAll() {
		log.debug("finding all Classes instances");
		try {
			String queryString = "from Classes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classes merge(Classes detachedInstance) {
		log.debug("merging Classes instance");
		try {
			Classes result = (Classes) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classes instance) {
		log.debug("attaching dirty Classes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classes instance) {
		log.debug("attaching clean Classes instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findByKeyWord(String keyword){
		try {
			String queryString = "from Classes as model where model.className like :name";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString("name", "%"+keyword+"%");
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}