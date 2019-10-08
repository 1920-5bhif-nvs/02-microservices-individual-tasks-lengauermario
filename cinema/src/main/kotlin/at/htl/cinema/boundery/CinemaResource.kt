package at.htl.cinema.boundery

import at.htl.cinema.control.CinemaDao
import at.htl.cinema.entity.Cinema
import at.htl.hall.control.HallDao
import at.htl.hall.entity.Hall
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cinema")
open class CinemaResource {

    @Inject
    lateinit var cinemaDao: CinemaDao

    @Inject
    lateinit var hallDao: HallDao

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): List<Cinema>{
        return cinemaDao.findAll()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create(cinema: Cinema): Cinema {
        return cinemaDao.add(cinema)
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun update(cinema: Cinema): Cinema {
        return cinemaDao.update(cinema)
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun update(@PathParam("id") id: Long, cinema: Cinema): Cinema {
        cinema.id = id
        return cinemaDao.update(cinema)
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun delete(cinema: Cinema): Cinema {
        return cinemaDao.delete(cinema.id!!)
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun delete(@PathParam("id") id: Long): Cinema {
        return cinemaDao.delete(id)
    }

    @POST
    @Path("/initialize")
    @Produces(MediaType.APPLICATION_JSON)
    fun initialize() : Response{
        var cinemas = arrayOf(
                Cinema().apply { name="Cineplex Linz"; address="Prinz-Eugen-Straße 22, 4020 Linz"},
                Cinema().apply { name="Cineplex Graz"; address="Alte Poststraße 470, 8055 Graz" }
        )
        cinemas.forEach { cinemaDao.add(it) }

/*
        var halls = arrayOf(
                Hall().apply{ name="DOLBY CINEMA"; seating=394;},
                Hall().apply{ name="Saal 2"; seating=133;},
                Hall().apply{ name="Saal 3"; seating=132;},
                Hall().apply{ name="Saal 1"; seating=247;},
                Hall().apply{ name="Saal 2"; seating=247;},
                Hall().apply{ name="Saal 3"; seating=184;}
        )
*/
       var halls = arrayOf(
                Hall().apply{ name="DOLBY CINEMA"; seating=394; cinema = cinemas[0]},
                Hall().apply{ name="Saal 2"; seating=133; cinema = cinemas[0]},
                Hall().apply{ name="Saal 3"; seating=132; cinema = cinemas[0]},
                Hall().apply{ name="Saal 1"; seating=247; cinema = cinemas[0]},
                Hall().apply{ name="Saal 2"; seating=247; cinema = cinemas[0]},
                Hall().apply{ name="Saal 3"; seating=184; cinema = cinemas[0]}
        )
        halls.forEach{hallDao.add(it)}

        return Response.ok("${cinemas.size} Cinemas and Halls are added.").build()
    }
}