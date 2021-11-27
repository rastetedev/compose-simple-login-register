package com.rastete.compose.signinup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rastete.compose.signinup.ui.theme.Shapes
import com.rastete.compose.signinup.ui.theme.SignInUpTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInUpTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SignUpScreen(this)
                }
            }
        }
    }
}

@Composable
private fun SignUpScreen(context: Context) {

    Column(modifier = Modifier.padding(16.dp)) {
        HeaderText()
        Spacer(modifier = Modifier.height(128.dp))
        EmailInput()
        Spacer(modifier = Modifier.height(16.dp))
        PasswordInput()
        Spacer(modifier = Modifier.height(64.dp))
        ButtonRegister()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonFBLogin()
        Spacer(modifier = Modifier.height(48.dp))
        ButtonToRegister(
            onClick = {
                context.startActivity(Intent(context, SignInActivity::class.java))
            }
        )
    }

}

@Composable
private fun HeaderText() {
    Column() {
        Text(text = "Crea un cuenta", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        Text(
            text = "Registrate para continuar",
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        )
    }
}

@Composable
private fun UsernameInput() {
    var username by remember { mutableStateOf("") }
    OutlinedTextField(
        value = username,
        onValueChange = { username = it },
        label = { Text(text = "Usuario") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
private fun EmailInput() {
    var email by remember { mutableStateOf("") }
    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text(text = "Correo electrónico") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
private fun PasswordInput() {
    var password by remember { mutableStateOf("") }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
private fun ButtonRegister() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        shape = RoundedCornerShape(20),
    ) {
        Text(text = "Registrate")
    }
}

@Composable
private fun ButtonFBLogin() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 1.dp),
        shape = RoundedCornerShape(20),
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painterResource(id = R.drawable.ic_facebook),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "     Conectarse con Facebook", color = Color.Blue)
        }
    }
}

@Composable
private fun ButtonToRegister(onClick: () -> Unit) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text(text = "¿Ya tienes una cuenta?")
        Text(
            text = "Inicia sesión",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}
