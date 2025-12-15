package sanji.ko.productlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import sanji.ko.productlist.data.Network
import sanji.ko.productlist.data.ProductRepository
import sanji.ko.productlist.ui.screens.ProductListScreen
import sanji.ko.productlist.ui.theme.ProductListTheme
import sanji.ko.productlist.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = ProductRepository(Network.api)
        val viewModel = ProductViewModel(repository)

        setContent { ProductListScreen(viewModel) }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductListTheme {
        Greeting("Android")
    }
}