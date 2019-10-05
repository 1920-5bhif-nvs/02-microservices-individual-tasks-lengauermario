package at.htl.hall.entity

import at.htl.cinema.entity.Cinema
import javax.persistence.*

@Entity
@NamedQuery(name = "hall.findAll", query = "select h from Hall h")
open class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    open lateinit var name: String
    open var seating: Int? = null

/*    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_id")
    var cinema: Cinema? = null*/
}