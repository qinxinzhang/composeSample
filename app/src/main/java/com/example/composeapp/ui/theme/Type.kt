package com.example.composeapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composeapp.R

// Set of Material typography styles to start with

val Popins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.W400),
    Font(R.font.poppins_medium, FontWeight.W500)
)

val PopinsTypography = Typography(
    h1 = TextStyle(
        fontFamily = Popins,
        fontWeight = FontWeight.W400,
        fontSize = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = Popins,
        fontWeight = FontWeight.W400,
        fontSize = 22.sp
    ),
    h3 = TextStyle(
        fontFamily = Popins,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    h4 = TextStyle(
        fontFamily = Popins,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),

    h5 = TextStyle(
        fontFamily = Popins,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),

    h6 = TextStyle(
        fontFamily = Popins,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    ),
    body1 = TextStyle(
        fontFamily = Popins,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */

)
