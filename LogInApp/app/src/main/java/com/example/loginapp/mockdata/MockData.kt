package com.example.loginapp.mockdata

import com.example.loginapp.Models.User

class MockData {
    //Equivalente al static
    companion object{
        val users = listOf<User>(
            User("castillojs374@gmail.com", "Password01"),
            User("castillojs485@gmail.com", "Password02"),
            User("castillojs596@gmail.com", "Password03")
        )
    }
}