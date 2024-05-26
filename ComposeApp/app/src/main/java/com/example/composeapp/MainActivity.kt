package com.example.composeapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun MyColumn(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola 1", modifier = Modifier
            .background(Color.Red)
            .weight(1f))
        Text("Hola 2", modifier = Modifier
            .background(Color.Blue)
            .weight(1f))
        Text("Hola 3", modifier = Modifier
            .background(Color.Cyan)
            .weight(1f))
        Text("Hola 4", modifier = Modifier
            .background(Color.LightGray)
            .weight(1f))
        Text("Hola 5", modifier = Modifier
            .background(Color.Magenta)
            .weight(1f))
    }
}

@Composable
fun MyList(){
    val products = listOf("Comida1","Comida2","Comida3","Comida4","Comida5","Comida6")
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        items(products){product ->
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        println("Producto: $product")
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.List, contentDescription = "Comida")
                Text(product)
            }
        }
    }
}

@Composable
fun MyRow(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(
                rememberScrollState()
            )
    ){
        Text("Ejemplo 1", modifier = Modifier
            .background(Color.Magenta)
            .width(100.dp))
        Text("Ejemplo 2", modifier = Modifier
            .background(Color.Cyan)
            .width(100.dp))
        Text("Ejemplo 3", modifier = Modifier
            .background(Color.Blue)
            .width(300.dp))
        Text("Ejemplo 4", modifier = Modifier
            .background(Color.Green)
            .width(100.dp))
    }
}

@Composable
fun MyBox(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        Text("Texto 1")
        Text("Texto más grande")
    }
}

@Composable
fun MyComplexLayout(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .height(100.dp)
                .weight(1f),
        ){

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .weight(1f)
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Text("Texto 1")
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .weight(1f),
                contentAlignment = Alignment.BottomEnd
            ){
                Text("Texto 2")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .height(100.dp)
                .weight(1f),
        ){

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MyState(){
    var contador = 0
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Contador: $contador")
        Button(onClick = {}) {
            Text("Incrementar")
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        MyState()
    }
}