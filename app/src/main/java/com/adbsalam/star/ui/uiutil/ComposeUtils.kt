package com.adbsalam.star.ui.uiutil

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adbsalam.star.R
import com.adbsalam.star.api.data.popular.MovieByGenre
import com.adbsalam.star.api.data.popular.MovieGenres
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import com.adbsalam.star.ui.theme.Purple40
import com.adbsalam.star.ui.uiutil.recycleritems.AppCompactPager
import com.adbsalam.star.ui.uiutil.recycleritems.MovieItem
import com.adbsalam.star.ui.uiutil.uidatamodels.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@Composable
fun AppClickableText(buttonModel: ButtonModel){
    ClickableText(
        modifier = Modifier.padding(vertical = 10.dp),
        text = AnnotatedString(buttonModel.buttonText),
        onClick = { buttonModel.onClickListener() },
        style = TextStyle(color = Purple40 , fontSize = 20.sp)
    )
}

@Composable
fun AppButton(buttonModel: ButtonModel){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier.align(Alignment.End).padding(vertical = 10.dp),
            onClick = {buttonModel.onClickListener()}
        ) {
            Text(text = buttonModel.buttonText,)
        }
    }
}

@Composable
fun AppImageView(imageModel: ImageModel){
    val image: Painter = painterResource(id = imageModel.resource)
    Image(
        painter = image,
        contentDescription = "",
        modifier = Modifier.height(imageModel.height).width(imageModel.width)
    )
}

@Composable
fun AppText(appTextModel: TextModel){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .padding(top = 20.dp),
        text = appTextModel.text,
        fontWeight = appTextModel.textType.fontWeight,
        fontSize = appTextModel.textType.fontSize,
        textAlign = TextAlign.Center
    )
}

@Composable
fun AppAnimatedButton(modifier: Modifier, buttonModel: ButtonModel, visibility: Boolean){
    CompactColumn(modifier.padding(horizontal = 40.dp)) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = visibility,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut()
        ) {
            AppButton(buttonModel)
        }
    }
}

@Composable
fun GetAppBarLogoImage(){
    Image(
        modifier = Modifier.padding(horizontal = 20.dp),
        painter = painterResource(R.drawable.mainlogo),
        contentDescription = "Contact profile picture",
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(pagerModel: PagerModel){
    val scope = rememberCoroutineScope()

    TabRow(selectedTabIndex = pagerModel.pagerState.currentPage) {
        pagerModel.pagerList.forEachIndexed{ index, model ->

            Tab(selected = pagerModel.pagerState.currentPage == index, onClick = {
                if(pagerModel.pagerState.currentPage != index){
                    scope.launch {
                        pagerModel.pagerState.animateScrollToPage(index)
                    }
                }
            }) {
                Text(
                    modifier = Modifier.padding(all = 10.dp),
                    text = model.title
                )
            }

        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun LoadMoviesListView(moviesList: List<PopularMoviesResponse.PopularMoviesList>){
    var pagerImages = listOf<PopularMoviesResponse.PopularMoviesList>()

    if(moviesList.size > 5){
        pagerImages = listOf(moviesList[0], moviesList[1], moviesList[2])
    }

    val listByGenre = ArrayList<MovieByGenre>()

    MovieGenres.values().forEach { genre ->
        val currentGenre = MovieByGenre()
        currentGenre.genreTitle = genre.name
        moviesList.forEach { movie ->
            if(movie.genre_ids[0] == genre.id){
                currentGenre.movieList.add(movie)
            }
        }
        listByGenre.add(currentGenre)
    }

    val pagerState = rememberPagerState(pageCount = 3)

    Column(Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            item {
                if(pagerImages.isNotEmpty()){
                    AppCompactPager(pagerState, pagerImages)
                }

                for (movieByGenre in listByGenre) {
                    if(movieByGenre.movieList.isNotEmpty()){
                        Text(
                            modifier = Modifier
                                .padding(all = 10.dp),
                            text = movieByGenre.genreTitle,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.W500
                            )
                        )

                        LazyRow{
                            item {
                                movieByGenre.movieList.forEach{ movie ->
                                    MovieItem(movie = movie)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextViewWithEndIconComposable(textViewDataModel: TextViewModel) {
    textViewDataModel.stateText = remember { mutableStateOf(TextFieldValue()) }
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
        var textState = textViewDataModel.stateText
        textState?.value?.let {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = it,
                label = { Text(textViewDataModel.initialValue) },
                onValueChange = {
                    textState?.value = it
                    textViewDataModel.textInitiated = true
                },
                keyboardOptions = textViewDataModel.showKeyboardType(),
                visualTransformation = textViewDataModel.getVisualTransformation(),
                isError = textViewDataModel.textInitiated && textViewDataModel.isErrorText(),
                trailingIcon = {
                    IconButton(onClick = {
                        textState?.value = TextFieldValue()
                        textViewDataModel.textInitiated = false
                    }
                    ) {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "",
                        )
                    }
                }
            )
        }
        if (textViewDataModel.textInitiated && textViewDataModel.isErrorText()) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                ){
                Text(
                    text = textViewDataModel.getErrorMessage(),
                    modifier = Modifier.align(Alignment.TopEnd),
                    textAlign = TextAlign.End,
                    color = Color.Red,
                    fontSize = 12.sp,
                )
            }
        }
    }

}