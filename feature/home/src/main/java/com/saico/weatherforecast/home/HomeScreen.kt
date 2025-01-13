package com.saico.weatherforecast.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.saico.theme.AppDim
import com.saico.theme.BorderDim
import com.saico.theme.FontSizes
import com.saico.theme.PaddingDim
import com.saico.ui.R
import com.saico.weatherforecast.common.getCurrentTime
import com.saico.weatherforecast.home.model.FutureModelItem
import com.saico.weatherforecast.home.model.HourlyUIState

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiStateHourly by viewModel.uiStateHourly.collectAsStateWithLifecycle()

    Content(
        uiStateHourly = uiStateHourly
    )
}

@Composable
fun Content(
    uiStateHourly: HourlyUIState
) {
    WeatherScreen(
        uiStateHourly = uiStateHourly
    )
}

@Composable
fun WeatherScreen(
    uiStateHourly: HourlyUIState
) {
//    val items = listOf(
//        uiStateHourly,
//        uiStateHourly,
//        uiStateHourly,
//        uiStateHourly,
//        uiStateHourly
//    )
    val dailyItems = listOf(
        FutureModelItem(
            stringResource(R.string.sat),
            "storm",
            stringResource(R.string.storm),
            24,
            12
        ),
        FutureModelItem(
            stringResource(R.string.sun),
            "cloudy",
            stringResource(R.string.cloudy),
            25,
            16
        ),
        FutureModelItem(
            stringResource(R.string.mon),
            "windy",
            stringResource(R.string.windy),
            29,
            15
        ),
        FutureModelItem(
            stringResource(R.string.thu),
            "cloudy_sunny",
            stringResource(R.string.cloudy_sunny),
            23,
            12
        ),
        FutureModelItem(
            stringResource(R.string.wed),
            "sunny",
            stringResource(R.string.sunny),
            28,
            11
        ),
        FutureModelItem(
            stringResource(R.string.thu),
            "rainy",
            stringResource(R.string.rainy),
            23,
            14
        ),
        FutureModelItem(
            stringResource(R.string.fri),
            "sunny",
            stringResource(R.string.sunny),
            22,
            12
        ),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#59469d")),
                        Color(android.graphics.Color.parseColor("#643d67")),
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = stringResource(id = R.string.mostly_cloudy),
                        fontSize = FontSizes.TITLE,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = PaddingDim.VERY_HUGE),
                        textAlign = TextAlign.Center
                    )
                    Image(
                        painter = painterResource(id = R.drawable.cloudy_sunny),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = PaddingDim.SMALL)
                            .size(AppDim.ROW_DATA_TIME_SIZE)
                    )
                    //Display date and time
                    Text(
                        text = getCurrentTime(),
                        fontSize = FontSizes.TITLE,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = PaddingDim.SMALL)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    //Display temperature details
                    Text(
                        text = "25 grados", // buscar OpenWeatherMap
                        fontSize = FontSizes.EXTRA_BIG,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = PaddingDim.SMALL)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "H:27 L:18", // buscar OpenWeatherMap
                        fontSize = FontSizes.ACCENT,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = PaddingDim.SMALL)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Box(
                        modifier = Modifier
                            .padding(
                                horizontal = PaddingDim.EXTRA_LARGE,
                                vertical = PaddingDim.EXTRA_LARGE
                            )
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.purple),
                                shape = RoundedCornerShape(BorderDim.EXTRA_LARGE),
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(vertical = PaddingDim.SMALL),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            WeatherDetailItem(icon = R.drawable.rain, label = "22%", value = "Rain")
                            WeatherDetailItem(
                                icon = R.drawable.wind,
                                label = "22%",
                                value = "Wind Speed"
                            )
                            WeatherDetailItem(
                                icon = R.drawable.humidity,
                                label = "22%",
                                value = "Humidity"
                            )
                        }
                    }
                    Text(
                        text = "Today",
                        fontSize = FontSizes.TITLE,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = PaddingDim.EXTRA_LARGE,
                                horizontal = PaddingDim.EXTRA_LARGE
                            )
                    )
                }
                //Display future hourly forecasr isng a LyzyRow
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = PaddingDim.EXTRA_LARGE),
                        horizontalArrangement = Arrangement.spacedBy(PaddingDim.SMALL)
                    ) {
                        items(items) { item ->
                            FutureModel(item)
                        }
                    }
                }

                //Display "Future" label and next 7 day button
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = PaddingDim.EXTRA_LARGE,
                                vertical = PaddingDim.LARGE
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.future),
                            fontSize = FontSizes.TITLE,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Text(
                            text = stringResource(id = R.string.next_7_days),
                            fontSize = FontSizes.DEFAULT,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,

                            )
                    }
                }
                items(dailyItems) { item ->
                    FutureItem(item = item)
                }
            }
        }
    }
}

@Composable
fun FutureItem(item: FutureModelItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = PaddingDim.EXTRA_LARGE, vertical = PaddingDim.VERY_SMALL),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.day,
            fontSize = FontSizes.DEFAULT,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = PaddingDim.SMALL)
        )
//        Image(
//            painter = painterResource(id = getDrawableResourceID(picPath = item.picPath)),
//            contentDescription = null,
//            modifier = Modifier
//                .padding(PaddingDim.HUGE)
//                .size(PaddingDim.VERY_HUGE)
//        )
        Text(
            text = item.status,
            fontSize = FontSizes.DEFAULT,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
                .padding(start = PaddingDim.LARGE)
        )
        Text(
            text = item.highTemp.toString(),
            fontSize = FontSizes.DEFAULT,
            color = Color.White,
            modifier = Modifier
                .padding(start = PaddingDim.LARGE, end = PaddingDim.MEDIUM)
        )
        Text(
            text = item.lowTemp.toString(),
            fontSize = FontSizes.DEFAULT,
            color = Color.White,
        )
    }
}

@Composable
fun getDrawableResourceID(picPath: String): Int {
    return when (picPath) {
        "storm" -> R.string.storm
        "cloudy" -> R.string.cloudy
        "windy" -> R.string.windy
        "cloudy_sunny" -> R.string.cloudy_sunny
        "sunny" -> R.string.sunny
        "rainy" -> R.string.rainy
        else -> R.string.sunny
    }
}

val items = listOf(
    HourlyUIState("9 pm", 28, "cloudy"),
    HourlyUIState("10 pm", 28, "sunny"),
    HourlyUIState("11 pm", 28, "wind"),
    HourlyUIState("12 pm", 28, "rainy"),
    HourlyUIState("1 am", 28, "storm")
)

@Composable
fun FutureModel(model: HourlyUIState) {

    Column(
        modifier = Modifier
            .width(90.dp)
            .wrapContentHeight()
            .padding(PaddingDim.VERY_SMALL)
            .background(
                color = colorResource(id = R.color.purple),
                shape = RoundedCornerShape(BorderDim.SMALL)
            )
            .padding(PaddingDim.SMALL),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = model.hour,
            color = Color.White,
            fontSize = FontSizes.ACCENT,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingDim.SMALL),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(
                id =
                when (model.picPath) {
                    "cloudy" -> R.drawable.cloudy
                    "sunny" -> R.drawable.sunny
                    "rainy" -> R.drawable.rain
                    "storm" -> R.drawable.storm
                    "wind" -> R.drawable.wind
                    else -> R.drawable.sunny
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(AppDim.USER_IMAGE_SIZE)
                .padding(PaddingDim.SMALL),
            contentScale = ContentScale.Crop
        )
        Text(
            text = model.temp.toString(),
            color = Color.White,
            fontSize = FontSizes.ACCENT,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingDim.SMALL),
            textAlign = TextAlign.Center
        )
//        Text(
//            text = model.picPath,
//            color = Color.White,
//            fontSize = FontSizes.ACCENT,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(PaddingDim.SMALL),
//            textAlign = TextAlign.Center
//        )
    }
}

@Composable
fun WeatherDetailItem(icon: Int, value: String, label: String) {

    Column(
        modifier = Modifier
            .padding(PaddingDim.LARGE),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(AppDim.LIST_ICONS_SIZE)
                .padding(end = PaddingDim.SMALL)
        )
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Text(
            text = label,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}