package at.htl.hall.control

import at.htl.hall.entity.Hall
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.transaction.Transactional

@ApplicationScoped
open class HallDao {

    @Inject
    open lateinit var em: EntityManager

    open fun findAll(): List<Hall>{
        val e = em.createNamedQuery("hall.findAll", Hall::class.java)
        return e.resultList
    }

    @Transactional
    open fun add(hall: Hall): Hall {
        em.persist(hall)
        return hall
    }

    @Transactional
    open fun update(hall: Hall): Hall {
        return em.merge(hall)
    }

    @Transactional
    open fun delete(hallId: Long): Hall {
        val toRemove = em.find(Hall::class.java, hallId)
        em.remove(toRemove)
        return toRemove
    }
}