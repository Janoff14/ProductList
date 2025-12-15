package sanji.ko.productlist.data

class ProductRepository (private val api: ProductApi) {

    suspend fun fetchProducts(): List<Product> {
        return api.getProducts()
    }
}