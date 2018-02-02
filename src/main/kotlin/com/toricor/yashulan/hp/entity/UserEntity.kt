package com.toricor.yashulan.hp.entity
import java.sql.Timestamp;

data class User(
        val id: Int,
        val name: String,
        val created_at: Timestamp,
        val updated_at: Timestamp
)