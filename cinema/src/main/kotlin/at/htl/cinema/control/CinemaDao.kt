package at.htl.cinema.control

import at.htl.cinema.entity.Cinema
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.transaction.Transactional


@ApplicationScoped
open class CinemaDao {

    @Inject
    open lateinit var em: EntityManager

    open fun findAll(): List<Cinema>{
        val e = em.createNamedQuery("cinema.findAll", Cinema::class.java)
        return e.resultList
    }

    @Transactional
    open fun add(cinema: Cinema): Cinema {
        em.persist(cinema)
        return cinema
    }

    @Transactional
    open fun update(cinema: Cinema): Cinema {
        return em.merge(cinema)
    }

    @Transactional
    open fun delete(cinemaId: Long): Cinema {
        val toRemove = em.find(Cinema::class.java, cinemaId)
        em.remove(toRemove)
        return toRemove
    }
}