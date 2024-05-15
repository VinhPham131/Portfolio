package com.midterm.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.midterm.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioTheme {
                val status = remember {
                    mutableStateOf(false)
                }
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card(
                        modifier = Modifier
                            .width(200.dp)
                            .height(390.dp)
                            .padding(12.dp),
                        shape = RoundedCornerShape(corner = CornerSize(15.dp))
                    ) {
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CreateImage()
                            CreateInfo()
                            Button(onClick = {
                                status.value = !status.value
                            }) {
                                Text(text = "Show Portfolio")
                            }
                            Divider()
                            if(status.value)
                                Portfolio(data = listOf("Android", "iOS", "Web", "Desktop"))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CreateInfo() {
     Column(modifier = Modifier.padding(3.dp)) {
         Text (text = "Pham Quang Vinh",
             style = MaterialTheme.typography.headlineLarge)

         Text (text = "The most handsome guy in the world",
             modifier = Modifier.padding(3.dp))

         Text (text = "@themeCompose",
             style = MaterialTheme.typography.titleMedium,
             modifier = Modifier.padding(3.dp))
     }
}

@Preview
@Composable
fun CreateImage() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(5.dp, color = Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ){
        Image(painter = painterResource(id = R.drawable.vinh),
            contentDescription = "profile picture",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop)

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
fun Portfolio(data : List<String>) {
    LazyColumn {
        items(data) {
            item ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RectangleShape
            ) {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    CreateImage()
                    Column(
                        modifier = Modifier
                            .padding(3.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "The most handsome guy in the world", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioTheme {
        Greeting("Android")
    }
}