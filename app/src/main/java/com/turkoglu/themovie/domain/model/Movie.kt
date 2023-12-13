package com.turkoglu.themovie.domain.model

data class Movie(

    val genreIds: List<Int>,
    val id: Int, // 297761
    val overview: String, // From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.
    val popularity: Double, // 48.261451
    val imageUrl: String, // /e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg
    val releaseDate: String, // 2016-08-03
    val title: String

)
