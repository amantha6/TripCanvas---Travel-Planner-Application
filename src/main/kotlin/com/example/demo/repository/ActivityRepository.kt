package com.example.demo.repository

import com.example.demo.model.Activity
import com.example.demo.model.Itinerary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityRepository : JpaRepository<Activity, Long> {
    fun findByItinerary(itinerary: Itinerary): List<Activity>
}