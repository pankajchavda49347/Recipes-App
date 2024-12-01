package com.example.myreceipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class category(val idCategory: String,val strCategory: String, val strCategoryThumb: String, val strCategoryDescription: String):Parcelable


data class categoryResponce(val categories: List<category>)