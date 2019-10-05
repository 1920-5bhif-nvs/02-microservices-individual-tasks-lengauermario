package at.htl.cinema.entity

import at.htl.hall.entity.Hall
import javax.persistence.*


@Entity
@NamedQuery(name = "cinema.findAll", query = "select c from Cinema c")
open class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    open lateinit var name: String
    open lateinit var address:String

  /*  @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "halls")
    private val halls = mutableListOf<Hall>()*/
}