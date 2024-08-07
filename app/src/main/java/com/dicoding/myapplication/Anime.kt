package com.dicoding.myapplication


//import android.provider.ContactsContract.DisplayPhoto
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val description: String,
    val photo: Int,
): Parcelable {

}
