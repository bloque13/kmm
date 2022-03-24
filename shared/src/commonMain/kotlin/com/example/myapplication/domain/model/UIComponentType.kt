package com.example.myapplication.domain.model

sealed class UIComponentType{

    object Dialog: UIComponentType()

    object None: UIComponentType()
}