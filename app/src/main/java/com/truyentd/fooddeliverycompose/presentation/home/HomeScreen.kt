package com.truyentd.fooddeliverycompose.presentation.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.truyentd.fooddeliverycompose.R
import com.truyentd.fooddeliverycompose.ui.theme.Fiord
import com.truyentd.fooddeliverycompose.ui.theme.Gray
import com.truyentd.fooddeliverycompose.ui.theme.Mandy
import com.truyentd.fooddeliverycompose.ui.theme.Mandy8
import com.truyentd.fooddeliverycompose.ui.theme.SpringWood
import com.truyentd.fooddeliverycompose.ui.theme.TulipTree

@Preview(showBackground = true, device = Devices.PIXEL_3A, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen {}
}

@Composable
fun HomeScreen(onNavigateToRestaurantDetail: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SpringWood)
            .padding(vertical = 24.dp)
            .statusBarsPadding(),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            AddressDropdown()
            Spacer(
                modifier = Modifier
                    .width(0.dp)
                    .weight(1f)
            )
            NotificationWithBadge()
        }
        Text(
            modifier = Modifier.padding(top = 26.dp, start = 16.dp, end = 16.dp),
            text = "Hello, Compose!",
            style = TextStyle(color = Fiord, fontSize = 28.sp, fontWeight = FontWeight.W700),
        )
        Text(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
            text = "What do you want to eat?",
            style = TextStyle(color = Gray, fontSize = 16.sp),
        )
        Row(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryButton(
                iconRes = R.drawable.ic_heart,
                text = "Favorite",
                modifier = Modifier.size(40.dp)
            )
            CategoryButton(
                iconRes = R.drawable.ic_tag,
                text = "Cheap",
                modifier = Modifier.size(32.dp)
            )
            CategoryButton(
                iconRes = R.drawable.ic_trending,
                text = "Trend",
                modifier = Modifier.size(40.dp)
            )
            CategoryButton(
                iconRes = R.drawable.ic_more,
                text = "More",
                modifier = Modifier.size(40.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .width(0.dp)
                    .weight(1f),
                text = "Today's promo",
                style = TextStyle(color = Fiord, fontSize = 24.sp, fontWeight = FontWeight.W500),
            )
            Text(
                modifier = Modifier.wrapContentWidth(),
                text = "See all",
                style = TextStyle(color = Mandy, fontSize = 14.sp),
            )
        }
        LazyRow(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(count = 20) { _ ->
                FoodItem {
                    onNavigateToRestaurantDetail()
                }
            }
        }
    }
}

@Composable
private fun AddressDropdown() {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .height(36.dp)
            .background(color = Mandy8, shape = RoundedCornerShape(18.dp))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "16 Ly Thuong Kiet, Hai Chau", style = TextStyle(color = Gray))
        Spacer(modifier = Modifier.width(6.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_down),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = Mandy
        )
    }
}

@Composable
private fun NotificationWithBadge() {
    Box(
        modifier = Modifier
            .width(34.dp)
            .height(37.dp)
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(color = Mandy, shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
        Box(
            modifier = Modifier
                .size(14.dp)
                .background(color = TulipTree, shape = CircleShape)
                .border(color = Color.White, shape = CircleShape, width = 2.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
private fun CategoryButton(@DrawableRes iconRes: Int, text: String, modifier: Modifier) {
    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.size(74.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    modifier = modifier.align(Alignment.Center),
                    tint = Mandy
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = text,
            style = TextStyle(color = Gray, fontSize = 16.sp),
        )
    }
}
