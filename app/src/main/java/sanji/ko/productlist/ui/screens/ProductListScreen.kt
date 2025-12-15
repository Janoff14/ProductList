package sanji.ko.productlist.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sanji.ko.productlist.ui.components.ProductCard
import sanji.ko.productlist.viewmodel.ProductUiState
import sanji.ko.productlist.viewmodel.ProductViewModel

@Composable
fun ProductListScreen (viewModel: ProductViewModel){

    val state by viewModel.uiState.collectAsState()

    when(state) {
        is ProductUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is ProductUiState.Success -> {
            val products = (state as ProductUiState.Success).products
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(products) { product ->
                    ProductCard(product = product,
                        modifier = Modifier.fillMaxWidth())

                }
            }
        }
        is ProductUiState.Error -> {
            val message = (state as ProductUiState.Error).message
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Error: $message")
            }
        }
    }
}