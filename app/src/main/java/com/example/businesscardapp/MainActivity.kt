package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF154d44)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    NameCard(
        imagePainter = painterResource(R.drawable.android_logo),
        completeName = stringResource(R.string.complete_name),
        title = stringResource(R.string.title)
    )
    InfoCard(
        phoneNumber = stringResource(R.string.phone_number),
        socialMediaId = stringResource(R.string.social_media_id),
        emailAddress = stringResource(R.string.email_address)
    )
}

@Composable
fun NameCard(
    imagePainter: Painter,
    completeName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imagePainter, contentDescription = null, modifier = modifier
                .height(50.dp)
                .width(50.dp)
        )
        Text(
            text = completeName,
            fontSize = 42.sp,
            color = Color.White
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun InfoCard(
    phoneNumber: String,
    socialMediaId: String,
    emailAddress: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Divider(color = Color.Gray, thickness = 1.dp)
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 20.dp, bottom = 5.dp),
        )
        {
            val phoneIcon = painterResource(id = R.drawable.ic_phone)
            Icon(
                painter = phoneIcon,
                contentDescription = null,
                modifier = modifier.padding(start = 60.dp),
                Color(0xFF3ddc84)
            )
            Text(
                text = phoneNumber,
                modifier = modifier.padding(start = 25.dp),
                color = Color.White
            )
        }
        Divider(color = Color.Gray, thickness = 1.dp)
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 20.dp, bottom = 5.dp),
        )
        {
            val shareIcon = painterResource(id = R.drawable.ic_share)
            Icon(
                painter = shareIcon,
                contentDescription = null,
                modifier = modifier.padding(start = 60.dp),
                Color(0xFF3ddc84)
            )
            Text(
                text = socialMediaId,
                modifier = modifier.padding(start = 25.dp),
                color = Color.White
            )
        }
        Divider(color = Color.Gray, thickness = 1.dp)
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 20.dp, bottom = 5.dp),
        )
        {
            val mailIcon = painterResource(id = R.drawable.ic_mail)
            Icon(
                painter = mailIcon,
                contentDescription = null,
                modifier = modifier.padding(start = 60.dp),
                Color(0xFF3ddc84)
            )
            Text(
                text = emailAddress,
                modifier = modifier.padding(start = 25.dp),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF154d44)
        ) {
            BusinessCardApp()
        }
    }
}