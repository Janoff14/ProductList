package sanji.ko.productlist.data
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): List<Product>

}