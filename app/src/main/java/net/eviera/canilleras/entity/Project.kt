package net.eviera.canilleras.entity

import net.eviera.canilleras.util.Global

class Project {

    var id: Long? = null
    var name: String? = null
    val templates = List(4) { Template() }
    var saved = false
    var tipoCanillera : Global.TipoCanillera? = null

}