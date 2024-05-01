package com.example.loginapp.data.mockdata

import com.example.loginapp.domain.Models.User

class MockData {
    //Equivalente al static
    companion object{
        val users = listOf<User>(
            User(1,"castillojs374@gmail.com", "Password01"),
            User(2, "castillojs485@gmail.com", "Password02"),
            User(3, "castillojs596@gmail.com", "Password03")
        )
    }
}