package at.htl.hall.entity

import at.htl.cinema.entity.Cinema
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.xml.bind.annotation.XmlTransient

@Entity
@NamedQuery(name = "hall.findAll", query = "select h from Hall h")
data class Hall(
        var name: String = "",
        var seating: Int? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne //(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_id")
    lateinit var cinema: Cinema
}