package com.example.demo.repository

import com.example.demo.model.Itinerary
import com.example.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItineraryRepository : JpaRepository<Itinerary, Long> {
    fun findByUser(user: User): List<Itinerary>
}