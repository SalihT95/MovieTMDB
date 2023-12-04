package com.turkoglu.themovie.domain.use_case.get_movies

import android.os.Build
import androidx.annotation.RequiresExtension
import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.domain.repo.MovieRepository
import com.turkoglu.themovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository : MovieRepository) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @Throws(Exception::class) // tek tür hata döndermek için yazılabilir
    fun executeGetMovies() : Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        val movieList = repository.getMovies()
        emit(Resource.Success(movieList))

        /*try {


        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Could not reach internet"))
        }

         */
    }

}