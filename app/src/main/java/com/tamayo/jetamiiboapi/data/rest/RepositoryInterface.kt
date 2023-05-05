package com.tamayo.jetamiiboapi.data.rest

import com.tamayo.jetamiiboapi.domain.ItemsDomain
import com.tamayo.jetamiiboapi.domain.toDomain
import com.tamayo.jetamiiboapi.utils.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface RepositoryInterface {

    fun getItems(): Flow<UIState<List<ItemsDomain>>>

}

class RepositoryInterfaceImpl @Inject constructor(
    private val serviceApi: ServiceApi,
    private val ioDispatcher: CoroutineDispatcher
    ): RepositoryInterface{

    override fun getItems(): Flow<UIState<List<ItemsDomain>>> = flow<UIState<List<ItemsDomain>>> {
        emit(UIState.LOADING)
        try {
            val response = serviceApi.getItems()

            if (response.isSuccessful){
                response.body()?.let {
                    emit(UIState.SUCCESS(it.amiibo.toDomain()))
                }?: throw Exception("Response body was null")
            }else{
                throw Exception(response.errorBody()?.string())
            }


        }catch (error: Exception){
            emit(UIState.ERROR(error))
        }

    }.flowOn(ioDispatcher)

}