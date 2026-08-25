package plat.lab5.acastrom

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import plat.lab5.acastrom.ui.theme.Lab_5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaJornada()
                }
            }
        }
    }
}

@Composable
fun PantallaJornada (modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        Actualizacion ()
        Spacer (modifier = Modifier.height(16.dp))
        FechaEncabezado()
        Spacer(modifier = Modifier.height(16.dp))
        BloqueRestaurante()
    }
}

@Composable
fun Actualizacion (modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Actualización",
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Actualización disponible",
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        TextButton(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.whatsapp"))
            context.startActivity(intent)
        }) {
            Text("Descargar")
        }
    }
}
@Composable

fun FechaEncabezado (modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Domingo",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "16 de agosto",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        OutlinedButton(onClick = { }) {
            Text("Finalizar jornada")
        }
    }
}

@Composable
fun BloqueRestaurante (modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier = modifier
        .fillMaxWidth(), shape = RoundedCornerShape(20.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "La Traila",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Cómo llegar?",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    IconButton(onClick = {
                        val nombreCodificado = Uri.encode("La Traila")
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("geo:14.591664,-90.5046965?q=14.591664,-90.5046965($nombreCodificado)")
                        )
                        context.startActivity(intent)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Place,
                            contentDescription = "Ubicación"
                        )
                    }
                }
            }

            Text(
                text = "16 Calle 14-49, Zona 10",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "10:00 AM – 8:00 PM",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {Toast.makeText(context, "Andrés Castro Morales", Toast.LENGTH_LONG).show()
                }) {
                    Text("Iniciar")
                }
                Spacer(modifier = Modifier
                    .width(16.dp))
                TextButton(onClick = {Toast.makeText(context, "Comida mexicana (tacos)\nNormal (QQ)", Toast.LENGTH_LONG).show()
                }) {
                    Text("Detalles")
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PantallaJornadaPreview() {
    Lab_5Theme {
        PantallaJornada()
    }
}