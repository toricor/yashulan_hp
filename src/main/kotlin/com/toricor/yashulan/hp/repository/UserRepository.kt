package com.toricor.yashulan.hp.repository

import com.toricor.yashulan.hp.entity.User

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectKey
import org.apache.ibatis.annotations.Update

@Mapper
interface UserRepository {

    @Select("SELECT * FROM users ORDER BY id")
    fun findAll(): List<User>

    @Select("SELECT * FROM users WHERE id = #{id}")
    fun findOne(@Param("id") id: Int): User

    @Insert("INSERT INTO users(first_name, last_name, address) VALUES(#{firstName}, #{lastName}, #{address})")
    @SelectKey(statement = arrayOf("call identity()"), keyProperty = "id", before = false, resultType = Int::class)
    fun insert(user: User)

    @Update("UPDATE users SET first_name = #{firstName}, last_name = #{lastName}, address = #{address} WHERE id = #{id}")
    fun update(user: User)

    @Delete("DELETE FROM users WHERE id = #{id}")
    fun delete(@Param("id") id: Int)

    @Select("""
        SELECT
            *
        FROM
            users
        WHERE
            first_name LIKE #{firstName}
        ORDER BY id
    """)
    fun findByFirstName(@Param("firstName") firstName: String): List<User>

    @Delete("DELETE FROM users")
    fun deleteAll()
}