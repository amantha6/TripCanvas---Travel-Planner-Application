package com.example.demo.controller

import com.example.demo.model.User
import com.example.demo.security.JwtTokenUtil
import com.example.demo.service.UserDetailsServiceImpl
import com.example.demo.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

data class LoginRequest(
    val email: String,
    val password: String
)

data class SignupRequest(
    val email: String,
    val password: String,
    val fullName: String
)

data class JwtResponse(
    val token: String,
    val id: Long,
    val email: String,
    val fullName: String
)

data class MessageResponse(
    val message: String
)

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val userService: UserService,
    private val userDetailsService: UserDetailsServiceImpl,
    private val jwtTokenUtil: JwtTokenUtil
) {

    @PostMapping("/signin")
    fun authenticateUser(@RequestBody loginRequest: LoginRequest): ResponseEntity<JwtResponse> {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(loginRequest.email, loginRequest.password)
        )

        SecurityContextHolder.getContext().authentication = authentication
        val userDetails = userDetailsService.loadUserByUsername(loginRequest.email)
        val jwt = jwtTokenUtil.generateToken(userDetails)
        val user = userService.getUserByEmail(loginRequest.email)

        return ResponseEntity.ok(
            JwtResponse(
                token = jwt,
                id = user.id,
                email = user.email,
                fullName = user.fullName
            )
        )
    }

    @PostMapping("/signup")
    fun registerUser(@RequestBody signupRequest: SignupRequest): ResponseEntity<MessageResponse> {
        try {
            val user = User(
                email = signupRequest.email,
                password = signupRequest.password, // Will be encoded in the service
                fullName = signupRequest.fullName,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )
            userService.createUser(user)
            return ResponseEntity.ok(MessageResponse("User registered successfully!"))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(MessageResponse(e.message ?: "Registration failed"))
        }
    }
} 