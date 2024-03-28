package br.com.leonardobarral.application_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_04.ui.theme.Application_04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application_04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculoImc()
                }
            }
        }
    }
}

@Composable
fun CalculoImc() {
    var pesoState by remember{
        mutableStateOf("")
    }
    var alturaState by remember{
        mutableStateOf("")
    }
    var imcState by remember{
        mutableStateOf(0.0)
    }
    var statusImcSatate by remember{
        mutableStateOf("")
    }
    var colorStatus by remember{
        mutableLongStateOf(0xFF329f6b)
    }




    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            )
    ){
        Column (
            modifier  = Modifier
                .background(
                    color = colorResource(id = R.color.red_project)
                )
                .fillMaxWidth()
                .height(200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Image(
                painter = painterResource(id = R.drawable.balanca),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(80.dp)
                    .padding(top = 16.dp)
            )

            Text(
                text = "Calculadora IMC",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        top = 12.dp,
                        bottom = 24.dp
                    )
            )

        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ){
            Card (
                modifier = Modifier
                    .offset(y = (-30).dp)
                    .fillMaxWidth(),
//                    .height(300.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFf9f6f6)
                ),
                elevation = CardDefaults.cardElevation(4.dp),
//                shape = CircleShape,
//                border = BorderStroke(
//                    width = 4.dp,
//                    color = Color.Blue
//                )

            ){
                Column (
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 32.dp)
                ){
                    Text(
                        text = "Seus Dados",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.red_project),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "Seu peso (Kg)",
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.red_project)
                    )
                    OutlinedTextField(
                        value = pesoState,
                        onValueChange = {
                            pesoState = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = {
                            Text(text = "ex: 100")
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(id = R.color.red_project),
                            focusedBorderColor = colorResource(id = R.color.red_project)
                        ),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Sua altura (cm)",
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.red_project)
                    )

                    OutlinedTextField(
                        value = alturaState,
                        onValueChange = {
                            alturaState = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = {
                            Text(text = "ex: 170")
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(id = R.color.red_project),
                            focusedBorderColor = colorResource(id = R.color.red_project)
                        ),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Row {
                        Button(
                            onClick = {
                                pesoState = ""
                                alturaState = ""
                                imcState = 0.0
                                statusImcSatate = ""
                                colorStatus = 0xFFFFFFFF
                            },
                            modifier = Modifier
                                .weight(0.5f)
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Gray
                            )
                        ) {
                            Text(
                                text = "LIMPAR",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Button(
                            onClick = {
                                imcState = calcularImc(
                                    pesoState.toDouble(),
                                    alturaState.toDouble()
                                )
                                statusImcSatate = obterStatusIMC(imcState)
                                colorStatus = obterCorStausIMC(statusImcSatate)

                            },
                            modifier = Modifier
                                .weight(0.5f)
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.red_project)
                            )
                        ) {
                            Text(
                                text = "CALCULAR",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }

            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 32.dp, vertical = 24.dp)
                    .align(Alignment.End),

                colors = CardDefaults.cardColors(
                    containerColor = Color(
//                        0xFF329f6b
                        colorStatus
                    )
                ),
                elevation = CardDefaults.cardElevation(4.dp),


            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .fillMaxSize()
                ){
                    Column (
                        modifier = Modifier.width(130.dp)
                    ){
                        Text(
                            text = "Resultado",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                        Text(
                            text = statusImcSatate,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                    Text(
                        text = String.format("%.1f",imcState),
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 28.sp,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Application_04ThemePreview() {
    CalculoImc()
}


