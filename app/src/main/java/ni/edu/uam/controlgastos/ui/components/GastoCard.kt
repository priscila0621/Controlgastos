package ni.edu.uam.controlgastos.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ni.edu.uam.controlgastos.model.Gasto

@Composable
fun GastoCard(gasto: Gasto) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = MaterialTheme.shapes.large
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Text(
                text = "Último gasto registrado",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Divider()

            Text(
                text = "Nombre: ${gasto.nombre}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Monto: C$ ${gasto.monto}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Categoría: ${gasto.categoria}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}