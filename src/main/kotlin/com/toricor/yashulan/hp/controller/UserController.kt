package com.toricor.yashulan.hp.controller

import com.toricor.yashulan.hp.entity.User
import com.toricor.yashulan.hp.service.UserService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/test")
    fun getTest() = "test"

    @GetMapping
    fun getUsers(): List<User> =
            userService.findAll()

    @GetMapping("{id}")
    fun getUser(@PathVariable id: Int): User =
            userService.findOne(id)
    /*
    @GetMapping("/search")
    fun getUsersByFirstName(@RequestParam firstName: String): List<User> =
            userService.findByFirstName(firstName)
    */
    // インサートはOKしかし500 Error
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User): User =
            userService.create(user)

    @PostMapping("{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody user: User): User {
        return userService.update(user)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Int) {
        userService.delete(id)
    }
}