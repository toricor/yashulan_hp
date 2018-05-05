package com.toricor.yashulan.hp.service

import com.toricor.yashulan.hp.entity.User
import com.toricor.yashulan.hp.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun findAll(): List<User> =
            userRepository.findAll()


    fun findOne(id: Int): User =
            userRepository.findOne(id)

    /*
    fun findByFirstName(firstName: String): List<User> =
            userRepository.findByFirstName(firstName)
    */

    fun create(user: User): User {
        userRepository.insert(user)
        return user
    }

    fun update(user: User): User {
        userRepository.update(user)
        return user
    }

    fun delete(id: Int) {
        userRepository.delete(id)
    }

}