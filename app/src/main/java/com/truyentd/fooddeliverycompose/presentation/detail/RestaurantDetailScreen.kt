package com.truyentd.fooddeliverycompose.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.truyentd.fooddeliverycompose.R
import com.truyentd.fooddeliverycompose.ui.theme.Fiord
import com.truyentd.fooddeliverycompose.ui.theme.Gray
import com.truyentd.fooddeliverycompose.ui.theme.Mandy
import com.truyentd.fooddeliverycompose.ui.theme.SpringWood

@Preview(showBackground = true, device = Devices.PIXEL_3A, showSystemUi = true)
@Composable
fun RestaurantDetailScreenPreview() {
    RestaurantDetailScreen {}
}

@Composable
fun RestaurantDetailScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SpringWood),
    ) {
        Box {
            AsyncImage(
                model = "https://c4.wallpaperflare.com/wallpaper/667/630/482/burger-dinner-food-hamburger-wallpaper-preview.jpg",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(273.dp),
                contentScale = ContentScale.Crop,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 16.dp, start = 16.dp)
                    .align(Alignment.TopStart)
                    .clickable { onBackClick() },
            )
            Image(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = null,
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 16.dp, end = 16.dp)
                    .align(Alignment.TopEnd),
            )
        }
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(168.dp)
                .offset(y = (-56).dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(16.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Delics Fruit Salad",
                        style = TextStyle(
                            color = Fiord,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W500
                        ),
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        text = "Jl. Jaya katwang no 4, Ngasem",
                        textAlign = TextAlign.Center,
                        style = TextStyle(color = Gray, fontSize = 16.sp),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.wrapContentSize(),
                            text = "Open",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                color = Fiord,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500
                            ),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            modifier = Modifier.wrapContentSize(),
                            text = "8am - 20pm",
                            textAlign = TextAlign.Center,
                            style = TextStyle(color = Gray, fontSize = 14.sp),
                        )
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .width(0.dp)
                .weight(1f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .background(color = Mandy, shape = RoundedCornerShape(4.dp))
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "Place order",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    ),
                )
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "18.000 VND",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp,
                    ),
                )
            }
        }
    }
}
