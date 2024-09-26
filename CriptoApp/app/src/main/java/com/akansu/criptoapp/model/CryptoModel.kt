package com.akansu.criptoapp.model

import com.google.gson.annotations.SerializedName
import java.util.Currency

data class CryptoModel
    (
     val currency: String,
     val price: String
     )