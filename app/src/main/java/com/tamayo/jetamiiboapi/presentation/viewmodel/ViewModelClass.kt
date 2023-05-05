package com.tamayo.jetamiiboapi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamayo.jetamiiboapi.data.rest.RepositoryInterface
import com.tamayo.jetamiiboapi.domain.ItemsDomain
import com.tamayo.jetamiiboapi.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelClass @Inject constructor(
    private val repositoryInterface: RepositoryInterface
) :
    ViewModel() {

    var selectedItem: ItemsDomain? = null


    private val _items: MutableStateFlow<UIState<List<ItemsDomain>>> =
        MutableStateFlow(UIState.LOADING)
    val items: StateFlow<UIState<List<ItemsDomain>>> get() = _items


    init {
        getItems()
    }

    private fun getItems() {
            viewModelScope.launch {
                repositoryInterface.getItems().collect{
                    _items.value = it
                }
            }
    }

}