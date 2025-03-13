package com.example.demo.repository

import com.example.demo.model.User
import com.example.demo.model.UserPreference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserPreferenceRepository : JpaRepository<UserPreference, Long> {
    fun findByUser(user: User): List<UserPreference>
}