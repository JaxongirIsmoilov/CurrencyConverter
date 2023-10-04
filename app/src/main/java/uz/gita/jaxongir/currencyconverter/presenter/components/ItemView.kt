package uz.gita.jaxongir.currencyconverter.presenter.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import uz.gita.jaxongir.currencyconverter.data.model.CurrencyCommonData
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import uz.gita.jaxongir.currencyconverter.R


@Composable
fun ItemView(
    data : CurrencyCommonData = CurrencyCommonData("", "", "", "", "", "", "", "", ""),
    selected : Boolean = false,
    onClick : (CurrencyCommonData) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick.invoke(data) }
            .background(if (selected) Color.Green else Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            val precent = "%.2f".format(((data.Rate.toFloat() * 100) / (data.Rate.toFloat() - data.Diff.toFloat())) - 100)

            AsyncImage(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://flagcdn.com/${data.Ccy.substring(0, 2).lowercase()}.svg")
                    .crossfade(true)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(22.dp))

            Column {
                Text(
                    text = data.Ccy,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF333333),
                    )
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = data.CcyNm_UZ,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_thin)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF808080),
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Column {
                Text(
                    text = data.Rate,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF333333),
                        textAlign = TextAlign.Right,
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "$precent%",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_thin)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF808080),
                            textAlign = TextAlign.Right,
                        )
                    )

                    Spacer(modifier = Modifier.width(7.dp))

                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(16.dp)
                            .height(16.dp),
                        painter = painterResource(id = (if (precent[0] != '-') R.drawable.increase else R.drawable.decrease)),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .padding(horizontal = 60.dp)
                .fillMaxWidth()
                .height(1.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color(0xFFDCDCDC))
        )

        Spacer(modifier = Modifier.height(12.dp))
    }
}