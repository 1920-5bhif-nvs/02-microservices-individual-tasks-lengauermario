package at.htl.hall.boundery

import at.htl.hall.control.HallDao
import at.htl.hall.entity.Hall
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/hall")
open class HallResource {
    @Inject
    lateinit var hallDao: HallDao

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): List<Hall>{
        return hallDao.findAll()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create(hall: Hall): Hall {
        return hallDao.add(hall)
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun update(hall: Hall): Hall {
        return hallDao.update(hall)
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun update(@PathParam("id") id: Long, hall: Hall): Hall {
        hall.id = id
        return hallDao.update(hall)
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun delete(hall: Hall): Hall {
        return hallDao.delete(hall.id!!)
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun delete(@PathParam("id") id: Long): Hall {
        return hallDao.delete(id)
    }
}