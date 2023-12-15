package com.turkoglu.themovie.domain.use_case.get_movie

import android.os.Build
import androidx.annotation.RequiresExtension
import com.turkoglu.themovie.domain.model.MovieDetail
import com.turkoglu.themovie.domain.repo.MovieRepository
import com.turkoglu.themovie.util.Resource
import com.turkoglu.themovie.util.toMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository : MovieRepository)  {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @Throws(Exception::class) // tek tür hata döndermek için yazılabilir
    fun executeGetMovie(movieId : Int) : Flow<Resource<MovieDetail>> = flow {
        emit(Resource.Loading())
        val movie = repository.getMovie(movieId =movieId)
        emit(Resource.Success(movie.toMovie()))

    }
}