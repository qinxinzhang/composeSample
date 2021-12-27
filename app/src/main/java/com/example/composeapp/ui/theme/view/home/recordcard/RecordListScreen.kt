package com.example.composeapp.ui.theme.view.home.recordcard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.composeapp.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun RecordListScreen(navController: NavController, token: String) {

    // Creates a CoroutineScope bound to the MoviesScreen's lifecycle
    val tabTitles = listOf("All", "Upcoming", "Missed", "Completed", "Cancelled")
    val pagerState = rememberPagerState()
    // Creates a CoroutineScope bound to the MoviesScreen's lifecycle
    val scope = rememberCoroutineScope()
    Column {
        ScrollableTabRow(
            backgroundColor = Color.White,
            // Our selected tab is our current page
            selectedTabIndex = pagerState.currentPage,
            // Override the indicator, using the provided pagerTabIndicatorOffset modifier
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            // Add tabs for all of our pages
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.W500
                        )
                    },
                    selectedContentColor = colorResource(id = R.color.black_111),
                    unselectedContentColor = colorResource(id = R.color.grey_4bf),
                    selected = pagerState.currentPage == index,
                    onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }

        HorizontalPager(
            count = tabTitles.size,
            state = pagerState,
        ) { index ->
            LazyColumn(
                modifier = Modifier.fillMaxHeight()
            ) {
                items(
                    count = 5,
                    itemContent = { CardItem(navController) }
                )
            }

        }
    }
}
