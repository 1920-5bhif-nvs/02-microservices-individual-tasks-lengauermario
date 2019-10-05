/*package at.htl

import at.htl.cinema.control.CinemaDao
import at.htl.cinema.entity.Cinema
import at.htl.hall.control.HallDao
import at.htl.hall.entity.Hall
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.Initialized
import javax.enterprise.event.Observes
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
open class DbSetup {

    @Inject
    lateinit var cinemaDao: CinemaDao

    @Inject
    lateinit var hallDao: HallDao

    @Transactional
    fun main(){

        var cinemas = arrayOf(
                Cinema(name="Cineplex Linz", address="Prinz-Eugen-Straße 22, 4020 Linz").apply { },
                Cinema(name="Cineplex Graz", address="Alte Poststraße 470, 8055 Graz").apply {  }
        )
        cinemas.forEach { cinemaDao.add(it) }

        var halls = arrayOf(
                Hall(cinema = cinemas[0]).apply{ name="DOLBY CINEMA"; seating=394; },
                Hall(cinema = cinemas[0]).apply{ name="Saal 2"; seating=133; },
                Hall(cinema = cinemas[0]).apply{ name="Saal 3"; seating=132; },
                Hall(cinema = cinemas[1]).apply{ name="Saal 1"; seating=247; },
                Hall(cinema = cinemas[1]).apply{ name="Saal 2"; seating=247; },
                Hall(cinema = cinemas[1]).apply{ name="Saal 3"; seating=184; }
        )
        halls.forEach{hallDao.add(it)}


    }
}
*/