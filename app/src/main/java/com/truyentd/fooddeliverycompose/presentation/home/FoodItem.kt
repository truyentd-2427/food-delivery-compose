package com.truyentd.fooddeliverycompose.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.transform.RoundedCornersTransformation
import com.truyentd.fooddeliverycompose.ui.theme.Fiord
import com.truyentd.fooddeliverycompose.ui.theme.Gray
import com.truyentd.fooddeliverycompose.ui.theme.Silver
import com.truyentd.fooddeliverycompose.ui.theme.TulipTree

@Preview
@Composable
fun FoodItemPreview() {
    FoodItem {}
}

@Composable
fun FoodItem(onItemClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .clickable { onItemClick() }
    ) {
        AsyncImage(
            model = "https://c4.wallpaperflare.com/wallpaper/667/630/482/burger-dinner-food-hamburger-wallpaper-preview.jpg",
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.BottomCenter),
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
                        text = "Fruit salad mix",
                        style = TextStyle(
                            color = Fiord,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500
                        ),
                    )
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = "Delics Fruit salad, Ngasem",
                        style = TextStyle(color = Gray, fontSize = 12.sp),
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .wrapContentSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "18.500",
                            style = TextStyle(
                                color = Fiord,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500
                            ),
                        )
                        Spacer(modifier = Modifier.width(11.dp))
                        Text(
                            text = "22.500",
                            style = TextStyle(
                                color = Silver,
                                fontSize = 12.sp,
                                textDecoration = TextDecoration.LineThrough
                            ),
                        )
                    }
                    Text(
                        text = "18.500",
                        style = TextStyle(
                            color = Fiord,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500
                        ),
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(end = 8.dp, bottom = 8.dp)
                        .wrapContentSize()
                        .align(Alignment.BottomEnd)
                        .background(color = TulipTree, shape = RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 6.dp),
                    text = "5 Left",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                    ),
                )
            }
        }
    }
}
