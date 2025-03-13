package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "activities")
data class Activity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(nullable = false)
    val title: String,
    
    @Column
    val description: String? = null,
    
    @Column(nullable = false)
    val startTime: LocalDateTime,
    
    @Column(nullable = false)
    val endTime: LocalDateTime,
    
    @Column
    val location: String? = null,
    
    @Column
    val latitude: Double? = null,
    
    @Column
    val longitude: Double? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itinerary_id", nullable = false)
    val itinerary: Itinerary,
    
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    
    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)