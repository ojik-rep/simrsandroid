package com.example.khanza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.khanza.ui.theme.KhanzaTheme
import com.example.khanza.ui.theme.LightPurple
import com.example.khanza.ui.theme.PrimaryColor
import com.example.khanza.ui.theme.TextColor
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KhanzaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HospitalHomePage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
//tes
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalHomePage(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(LightPurple, PrimaryColor)
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Hospital Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = "Melayani dengan tulus dan ikhlas",
            color = TextColor,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username Pegawai", color = TextColor) },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = TextColor,
                unfocusedBorderColor = TextColor,
                cursorColor = TextColor,
                focusedLabelColor = TextColor,
                unfocusedLabelColor = TextColor,
                focusedTextColor = TextColor,
                unfocusedTextColor = TextColor
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password Pegawai", color = TextColor) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = TextColor,
                unfocusedBorderColor = TextColor,
                cursorColor = TextColor,
                focusedLabelColor = TextColor,
                unfocusedLabelColor = TextColor,
                focusedTextColor = TextColor,
                unfocusedTextColor = TextColor
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Handle login */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor, contentColor = TextColor)
        ) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HospitalHomePagePreview() {
    KhanzaTheme {
        HospitalHomePage()
    }
}
