package ni.edu.uam.controlgastos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ni.edu.uam.controlgastos.model.Gasto
import ni.edu.uam.controlgastos.ui.components.InputField
import ni.edu.uam.controlgastos.ui.components.CategorySelector
import ni.edu.uam.controlgastos.ui.components.GastoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GastoScreen() {

    // Estados (el integrante 3 puede refinarlos luego, pero aquí van declarados)
    var nombre by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("Comida") }
    var mensaje by remember { mutableStateOf("") }
    var ultimoGasto by remember { mutableStateOf<Gasto?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Control de Gastos") }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // Campo nombre
            InputField(
                label = "Nombre del gasto",
                value = nombre,
                onValueChange = { nombre = it }
            )

            // Campo monto
            InputField(
                label = "Monto",
                value = monto,
                onValueChange = { monto = it }
            )

            // Selector categoría
            CategorySelector(
                selected = categoria,
                onSelected = { categoria = it }
            )

            // Botón guardar
            Button(
                onClick = {
                    if (nombre.isBlank() || monto.isBlank()) {
                        mensaje = "Por favor completa todos los campos"
                    } else if (monto.toDoubleOrNull() == null) {
                        mensaje = "El monto debe ser un número válido"
                    } else {
                        ultimoGasto = Gasto(nombre, monto, categoria)
                        mensaje = "Gasto registrado correctamente"

                        nombre = ""
                        monto = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar gasto")
            }

            // Mensaje dinámico
            if (mensaje.isNotEmpty()) {
                Text(
                    text = mensaje,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // Card del último gasto
            ultimoGasto?.let {
                GastoCard(gasto = it)
            }
        }
    }
}