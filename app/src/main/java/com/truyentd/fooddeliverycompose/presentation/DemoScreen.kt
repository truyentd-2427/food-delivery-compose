package com.truyentd.fooddeliverycompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

@Composable
fun DemoScreen() {
//    Column(
//        modifier = Modifier
//            .background(getRandomColor())
//            .fillMaxWidth()
//            .padding(4.dp)
//    ) {
//        var counter by remember { mutableIntStateOf(0) }
//
//
//        ExtractComposable(counter, onClick = { counter++ }) {
//            Text("Counter: $counter", color = getRandomColor())
//        }
//    }
    Sample3()
}

@Composable
private fun Sample1() {
    Column(
        modifier = Modifier
            .background(getRandomColor())
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        var counter by remember { mutableIntStateOf(0) }


        Text("Sample1", color = getRandomColor())

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
            onClick = {
                counter++
            }) {
            Text("Counter: $counter", color = getRandomColor())
        }
    }
}

@Composable
private fun Sample2() {
    Column(
        modifier = Modifier.background(getRandomColor())
    ) {

        var update1 by remember { mutableIntStateOf(0) }
        var update2 by remember { mutableIntStateOf(0) }

        println("ROOT")
        Text("Sample2", color = getRandomColor())

        Button(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 4.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
            onClick = {
                update1++
            },
            shape = RoundedCornerShape(5.dp)
        ) {

            println("🔥 Button1️")

            Text(
                text = "Update1: $update1",
                textAlign = TextAlign.Center,
                color = getRandomColor()
            )

        }

        Button(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
            onClick = { update2++ },
            shape = RoundedCornerShape(5.dp)
        ) {
            println("🍏 Button 2️")

            Text(
                text = "Update2: $update2",
                textAlign = TextAlign.Center,
                color = getRandomColor()
            )
        }

        Column(
            modifier = Modifier.background(getRandomColor())
        ) {

            println("🚀 Inner Column")
            var update3 by remember { mutableIntStateOf(0) }

            Button(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                onClick = { update3++ },
                shape = RoundedCornerShape(5.dp)
            ) {

                println("✅ Button 3️")
                Text(
                    text = "Update2: $update2, Update3: $update3",
                    textAlign = TextAlign.Center,
                    color = getRandomColor()
                )

            }
        }

        Column() {
            println("☕️ Bottom Column")
            Text(
                text = "Sample2",
                textAlign = TextAlign.Center,
                color = getRandomColor()
            )
        }

    }
}

@Composable
private fun Sample3() {
    Column(
        modifier = Modifier.background(getRandomColor())
    ) {

        var update1 by remember { mutableIntStateOf(0) }
        var update2 by remember { mutableIntStateOf(0) }

        println("ROOT")
        Text("Sample3", color = getRandomColor())

        Button(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 4.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
            onClick = {
                update1++
            },
            shape = RoundedCornerShape(5.dp)
        ) {

            println("🔥 Button1️")

            Text(
                text = "Update1: $update1",
                textAlign = TextAlign.Center,
                color = getRandomColor()
            )

        }

        Button(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
            onClick = { update2++ },
            shape = RoundedCornerShape(5.dp)
        ) {
            println("🍏 Button 2️")

            Text(
                text = "Update2: $update2",
                textAlign = TextAlign.Center,
                color = getRandomColor()
            )
        }

        Column {

            println("🚀 Inner Column")
            var update3 by remember { mutableIntStateOf(0) }

            Button(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                onClick = { update3++ },
                shape = RoundedCornerShape(5.dp)
            ) {

                println("✅ Button 3️")
                Text(
                    text = "Update2: $update2, Update3: $update3",
                    textAlign = TextAlign.Center,
                    color = getRandomColor()
                )

            }
        }
        // 🔥🔥 Reading update1 causes entire composable to recompose
        Column(
            modifier = Modifier.background(getRandomColor())
        ) {
            println("☕️ Bottom Column")
            Text(
                text = "Update1: $update1",
                textAlign = TextAlign.Center,
                color = getRandomColor()
            )
        }
    }
}

@Composable
fun ExtractComposable(counter: Int, onClick: () -> Unit, content: @Composable () -> Unit) {
    Column {
        Text("Sample1", color = getRandomColor())

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
            onClick = onClick
        ) {
            content()
        }
    }
}

fun getRandomColor(): Color {
    val random = Random.Default
    val red = random.nextInt(256)
    val green = random.nextInt(256)
    val blue = random.nextInt(256)

    return Color(red, green, blue)
}
