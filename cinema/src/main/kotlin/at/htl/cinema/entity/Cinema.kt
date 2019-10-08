package at.htl.cinema.entity

import at.htl.hall.entity.Hall
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.xml.bind.annotation.XmlTransient


@Entity
@NamedQuery(name = "cinema.findAll", query = "select c from Cinema c")
data class Cinema (
        var name: String = "",
        var address:String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null


    /*@OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "cinema")
    val halls = mutableListOf<Hall>()*/
}