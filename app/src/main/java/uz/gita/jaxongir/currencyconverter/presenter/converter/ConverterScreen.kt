package uz.gita.jaxongir.currencyconverter.presenter.converter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import uz.gita.jaxongir.currencyconverter.R
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData
import uz.gita.jaxongir.currencyconverter.ui.theme.CurrencyConverterTheme

class ConverterScreen(
    private val data1: CurrencyCommonData,
    private val data2: CurrencyCommonData
) : AndroidScreen() {
    @Composable
    override fun Content() {
        CurrencyConverterTheme {
            val viewModel: ConverterContract.ViewModel = getViewModel<ConverterViewModel>()

            ConverterContent(
                viewModel.uiState.collectAsState().value,
                viewModel::onEventDispatcher,
                data1 = data1,
                data2 = data2
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConverterContent(
    uiState: ConverterContract.UIState = ConverterContract.UIState(),
    onEventDispatcher: (ConverterContract.Intent) -> Unit = {},
    data1: CurrencyCommonData,
    data2: CurrencyCommonData
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 35.dp)
    ) {
        Column {
            var text by remember { mutableStateOf("") }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .width(36.dp)
                        .height(36.dp)
                        .clickable { onEventDispatcher.invoke(ConverterContract.Intent.Back) },
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back"
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Konvertatsiya",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF333333),
                        textAlign = TextAlign.Center,
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(11.dp))

            Text(
                text = "Jonli tariflarni tekshiring, miqdorni kiriting va konvertatsiya natijasiga ega bo`ling.",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF808080),
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.height(41.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 10.dp,
                        spotColor = Color(0x0D000000),
                        ambientColor = Color(0x0D000000)
                    )
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(size = 20.dp)
                    ),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Miqdori",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF808080),
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .height(48.dp)
                                .width(48.dp)
                                .align(Alignment.CenterVertically)
                                .clip(CircleShape),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(
                                    "https://flagcdn.com/${
                                        data1.Ccy.substring(0, 2).lowercase()
                                    }.svg"
                                )
                                .crossfade(true)
                                .decoderFactory(SvgDecoder.Factory())
                                .build(),
                            contentDescription = "image",
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(13.dp))

                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            text = data1.Ccy,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF26278D),
                            )
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        TextField(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .width(141.dp)
                                .align(Alignment.CenterVertically)
                                .clip(RoundedCornerShape(7.dp)),
                            value = text,
                            onValueChange = {
                                text = if (it.length > 7) it.substring(0, 7) else it
                            },
                            maxLines = 1,
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color(0xFFEFEFEF),
                                disabledTextColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF333333)
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(Color(0xFFE7E7EE))
                        )

                        Card(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .height(44.dp)
                                .width(44.dp)
                                .clip(RoundedCornerShape(60.dp))
                                .clickable { },
                            colors = CardDefaults.cardColors(Color(0xFF26278D))
                        ) {

                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Konvertatsiya qilingan miqdor",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(400),
                            color = Color(0x80808080),
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .height(48.dp)
                                .width(48.dp)
                                .align(Alignment.CenterVertically)
                                .clip(CircleShape),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(
                                    "https://flagcdn.com/${
                                        data2.Ccy.substring(0, 2).lowercase()
                                    }.svg"
                                )
                                .crossfade(true)
                                .decoderFactory(SvgDecoder.Factory())
                                .build(),
                            contentDescription = "image",
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(13.dp))

                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            text = data2.Ccy,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF26278D),
                            )
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        TextField(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .width(141.dp)
                                .align(Alignment.CenterVertically)
                                .clip(RoundedCornerShape(7.dp)),
                            value = if (text.isEmpty()) "0.00" else "%.2f".format((text.toFloat() * data1.Rate.toFloat()) / data2.Rate.toFloat()),
                            onValueChange = { },
                            enabled = false,
                            maxLines = 1,
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color(0xFFEFEFEF),
                                disabledTextColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(600),
                                color = Color(0x33333333)
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Indikativ valyuta kursi",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF808080),
                )
            )

            Spacer(modifier = Modifier.height(13.dp))

            Text(
                text = "1 ${data1.Ccy} = ${"%.4f".format(data1.Rate.toFloat() / data2.Rate.toFloat())} ${data2.Ccy}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF333333),
                )
            )
        }
    }
}