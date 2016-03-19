package me.hupeng.homeworkweb.DAO;

import java.util.List;

import me.hupeng.homeworkweb.bean.Courseware;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Courseware entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see me.hupeng.homeworkweb.bean.Courseware
 * @author MyEclipse Persistence Tools
 */
public class CoursewareDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CoursewareDAO.class);
	// property constants
	public static final String CLASS_ID = "classId";
	public static final String USER_ID = "userId";
	public static final String PATH = "path";
	public static final String FILENAME = "filename";
	public static final String UPDATE_TIME = "updateTime";

	public void save(Courseware transientInstance) {
		log.debug("saving Courseware instance");
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

	public void delete(Courseware persistentInstance) {
		log.debug("deleting Courseware instance");
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

	public Courseware findById(java.lang.Integer id) {
		log.debug("getting Courseware instance with id: " + id);
		try {
			Courseware instance = (Courseware) getSession().get(
					"me.hupeng.homeworkweb.bean.Courseware", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Courseware instance) {
		log.debug("finding Courseware instance by example");
		try {
			List results = getSession()
					.createCriteria("me.hupeng.homeworkweb.bean.Courseware")
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
		log.debug("finding Courseware instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Courseware as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClassId(Object classId) {
		return findByProperty(CLASS_ID, classId);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List findByUpdateTime(Object updateTime) {
		return findByProperty(UPDATE_TIME, updateTime);
	}

	public List findAll() {
		log.debug("finding all Courseware instances");
		try {
			String queryString = "from Courseware";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Courseware merge(Courseware detachedInstance) {
		log.debug("merging Courseware instance");
		try {
			Courseware result = (Courseware) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Courseware instance) {
		log.debug("attaching dirty Courseware instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Courseware instance) {
		log.debug("attaching clean Courseware instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}