package com.adbsalam.star.ui.uiutil.recycleritems

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.adbsalam.star.BuildConfig
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import com.google.accompanist.pager.*
import com.google.android.material.animation.AnimationUtils.lerp
import kotlin.math.absoluteValue


@SuppressLint("RestrictedApi")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun AppCompactPager(pagerState: PagerState, imagesList: List<PopularMoviesResponse.PopularMoviesList>){
    Box(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(700.dp)
            .background(Color.Black)
    ) {
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top,
            count = imagesList.size,

        ) { position ->

            Column(modifier = Modifier.fillMaxSize()) {
                Card(
                    shape = RoundedCornerShape(0),
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            val pageOffset = calculateCurrentOffsetForPage(position).absoluteValue

                            lerp(0.70f, 1f,  1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }

                            // We animate the alpha, between 50% and 100%
                            alpha = lerp(0.2f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                        },
                    elevation = CardDefaults.outlinedCardElevation(defaultElevation = 15.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = rememberAsyncImagePainter("${BuildConfig.API_IMAGE_BASE_URL}${imagesList[position].poster_path}"),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }

            }

           // ImageItem(movies = imagesList[position].poster_path)
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .padding(all = 20.dp),
            pagerState = pagerState,
            activeColor = Color.White
        )
    }
}

@Composable
fun ImageItem(movies: String){
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp),
            elevation = CardDefaults.outlinedCardElevation(defaultElevation = 15
                .dp)
            ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberAsyncImagePainter("${BuildConfig.API_IMAGE_BASE_URL}$movies"),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }

    }
}

@Composable
fun MovieItem(movie: PopularMoviesResponse.PopularMoviesList){
    Card(modifier = Modifier
        .padding(horizontal = 5.dp, vertical = 20.dp)
        .width(160.dp)
        .height(250.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(Color.Black)
    ) {
        Column(){
            Image(
                modifier = Modifier
                    .fillMaxSize() ,
                painter = rememberAsyncImagePainter("${BuildConfig.API_IMAGE_BASE_URL}${movie.poster_path}"),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
//            Row(modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 10.dp)
//                .weight(1f)
//            ) {
//                Column(modifier = Modifier.fillMaxHeight(),
//                    horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
//                    Icon(
//                        painterResource(id = R.drawable.ic_baseline_data_saver_on_24),
//                        contentDescription ="",
//                        tint = Color.White
//                    )
//                }
//                Column(modifier = Modifier.fillMaxSize(),
//                    horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center) {
//                    Icon(
//                        painterResource(id = R.drawable.ic_outline_manage_search_24),
//                        contentDescription ="",
//                        tint = Color.White
//                    )
//                }
//            }
        }

    }
}


