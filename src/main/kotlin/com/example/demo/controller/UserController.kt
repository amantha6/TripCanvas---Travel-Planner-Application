package com.example.demo.controller

import com.example.demo.model.User
import com.example.demo.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping("/profile")
    fun getCurrentUser(@AuthenticationPrincipal userDetails: UserDetails): ResponseEntity<User> {
        val user = userService.getUserByEmail(userDetails.username)
        return ResponseEntity.ok(user)
    }

    @PutMapping("/profile")
    fun updateProfile(
        @AuthenticationPrincipal userDetails: UserDetails,
        @RequestBody updatedUser: User
    ): ResponseEntity<User> {
        val user = userService.getUserByEmail(userDetails.username)
        val updated = userService.updateUser(user.id, updatedUser)
        return ResponseEntity.ok(updated)
    }
}