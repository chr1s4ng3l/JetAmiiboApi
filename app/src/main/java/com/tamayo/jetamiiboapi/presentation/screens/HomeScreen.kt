package com.tamayo.jetamiiboapi.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tamayo.jetamiiboapi.domain.ItemsDomain
import com.tamayo.jetamiiboapi.presentation.navgraph.Routes
import com.tamayo.jetamiiboapi.presentation.viewmodel.ViewModelClass
import com.tamayo.jetamiiboapi.utils.UIState

@Composable
fun HomeScreen(vm: ViewModelClass, navController: NavController) {

    when (val state = vm.items.collectAsState(UIState.LOADING).value) {
        is UIState.LOADING -> {}
        is UIState.SUCCESS -> {
            ItemList(state.data, navController) {
                vm.selectedItem = it
            }
        }

        is UIState.ERROR -> {
            Toast.makeText(LocalContext.current, "Item not found", Toast.LENGTH_LONG).show()
        }
    }

}

@Composable
fun ItemList(
    items: List<ItemsDomain>,
    navController: NavController? = null,
    selectedItems: ((ItemsDomain) -> Unit)? = null

) {
    Column(
        Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {

        LazyColumn(
            content = {
                itemsIndexed(items = items) { _, item ->
                    Items(item = item, navController, selectedItems)
                }
            }

        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Items(
    item: ItemsDomain,
    navController: NavController? = null,
    selectedItem: ((ItemsDomain) -> Unit)? = null

) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(horizontal = 8.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {
            selectedItem?.invoke(item)

            navController?.navigate(Routes.Details.route)
        }
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(alignment = Alignment.Center),
                text = item.name,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp
            )

        }
    }
}