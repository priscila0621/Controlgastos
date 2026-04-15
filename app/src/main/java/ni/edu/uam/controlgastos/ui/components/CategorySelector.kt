package ni.edu.uam.controlgastos.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategorySelector(
    selected: String,
    onSelected: (String) -> Unit
) {
    val categorias = listOf("Comida", "Transporte", "Servicios", "Otros")

    Column {
        Text(
            text = "Categoría",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        categorias.forEach { categoria ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = selected == categoria,
                    onClick = { onSelected(categoria) }
                )

                Text(
                    text = categoria,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}