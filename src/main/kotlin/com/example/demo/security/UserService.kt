package com.example.demo.service

import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun createUser(user: User): User {
        if (userRepository.existsByEmail(user.email)) {
            throw RuntimeException("Email already exists")
        }
        
        val encodedPassword = passwordEncoder.encode(user.password)
        val newUser = user.copy(password = encodedPassword)
        return userRepository.save(newUser)
    }

    fun getUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
            .orElseThrow { UsernameNotFoundException("User not found with email: $email") }
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun updateUser(id: Long, updatedUser: User): User {
        val existingUser = userRepository.findById(id)
            .orElseThrow { RuntimeException("User not found with id: $id") }
        
        // Update only non-null fields
        val userToUpdate = existingUser.copy(
            fullName = updatedUser.fullName,
            profilePicture = updatedUser.profilePicture ?: existingUser.profilePicture,
            updatedAt = LocalDateTime.now()
        )
        
        return userRepository.save(userToUpdate)
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}