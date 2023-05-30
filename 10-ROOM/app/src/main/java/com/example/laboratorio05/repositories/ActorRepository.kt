package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.dao.ActorDao
import com.example.laboratorio05.data.model.ActorModel

class ActorRepository(private val actorsDao: ActorDao) {

    suspend fun getActors() = actorsDao.getAllActors()

    suspend fun addActors(actor: ActorModel) = actorsDao.insertActor(actor)

}