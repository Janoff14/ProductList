package sanji.ko.productlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sanji.ko.productlist.data.Product
import sanji.ko.productlist.data.ProductRepository

sealed interface ProductUiState {
    object Loading : ProductUiState
    data class Success(val products: List<Product>) : ProductUiState
    data class Error(val message: String) : ProductUiState
}

class ProductViewModel (private val repository: ProductRepository): ViewModel() {

    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val uiState: StateFlow<ProductUiState> = _uiState.asStateFlow()

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        _uiState.value = ProductUiState.Loading
        viewModelScope.launch {
            try {
                val products = repository.fetchProducts()
                _uiState.value = ProductUiState.Success(products)
            } catch (e: Exception) {
                _uiState.value = ProductUiState.Error(e.localizedMessage ?: "An unexpected error occurred")
            }
        }
    }
}