package plat.lab4.acastrom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import plat.lab4.acastrom.ui.theme.Lab_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TarjetaUVG(modifier = Modifier.padding(24.dp))
                }
            }
        }
    }
}

@Composable
fun TarjetaUVG(modifier: Modifier = Modifier) {
    val integrantes = listOf(
        "Andrés Castro Morales",
        "Sebastián García",
        "Carlos Pozuelos"
    )

    Box(
        modifier = modifier
            .width(280.dp)
            .height(400.dp)
            .border(width = 2.dp, color = Color.Green)
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.escudo_uvg),
            contentDescription = "Escudo UVG",
            modifier = Modifier
                .align(Alignment.Center)
                .width(700.dp),
            alpha = 0.15f
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Universidad del Valle\nde Guatemala",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Programación de plataformas\nmóviles, Sección 21",
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row {
                Text(text = "INTEGRANTES", fontWeight = FontWeight.Bold, fontSize = 9.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    integrantes.forEach { nombre ->
                        Text(text = nombre, fontSize = 9.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(text = "CATEDRÁTICO", fontWeight = FontWeight.Bold, fontSize = 9.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Juan Carlos Durini", fontSize = 9.sp)
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(text = "Andrés Castro Morales", fontSize = 8.sp, textAlign = TextAlign.Center)
            Text(text = "25039", fontSize = 8.sp, textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaUVGPreview() {
    Lab_4Theme {
        TarjetaUVG()
    }
}