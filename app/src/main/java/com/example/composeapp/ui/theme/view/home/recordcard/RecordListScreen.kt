package com.example.composeapp.ui.theme.view.home.recordcard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item
import com.example.composeapp.data.database.model.RecordViewModel
import com.example.composeapp.data.database.model.helper.RecordType
import com.example.composeapp.utils.TeleDoctorHelper
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun RecordListScreen(navController: NavController, token: String) {

    // Creates a CoroutineScope bound to the MoviesScreen's lifecycle
    val tabTitles = listOf("All", "Upcoming", "Missed", "Completed", "Cancelled")
    val pagerState = rememberPagerState()
    val recordViewModel: RecordViewModel = viewModel()
    // Creates a CoroutineScope bound to the MoviesScreen's lifecycle
    val scope = rememberCoroutineScope()
    LaunchedEffect(pagerState.pageCount) {
        recordViewModel.getRecordList(token)
    }
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
            val itemList = recordViewModel.recordResponse.baseResponse?.d?.Items
            val currentTime = recordViewModel.recordResponse.date ?: ""
            itemList?.let { records ->
                when (index) {
                    ALL -> RecordList(list = records, currentTime = currentTime, navController)
                    UPCOMING -> RecordList(
                        list = filterList(
                            RecordType.TYPE_UPCOMING,
                            records,
                            currentTime
                        ), currentTime = currentTime, navController
                    )
                    MISSED -> RecordList(
                        list = filterList(
                            RecordType.TYPE_MISSED,
                            records,
                            currentTime
                        ), currentTime = currentTime, navController
                    )
                    COMPLETED -> RecordList(
                        list = filterList(
                            RecordType.TYPE_COMPLETED,
                            records,
                            currentTime
                        ),
                        currentTime = currentTime,
                        navController
                    )
                    CANCELLED -> RecordList(
                        list = filterList(
                            RecordType.TYPE_CANCELLED,
                            records,
                            currentTime
                        ),
                        currentTime = currentTime,
                        navController
                    )
                }
            }
        }
    }
}

fun filterList(recordType: Int, list: List<Item>, currentTime: String): List<Item> {
    return when (recordType) {
        RecordType.TYPE_UPCOMING -> {
            list.filter {
                TeleDoctorHelper.convertRecordStatus(
                    it.status,
                    currentTime,
                    it.start,
                    it.end
                ) == RecordType.TYPE_UPCOMING
            }
        }
        RecordType.TYPE_MISSED -> {
            list.filter {
                TeleDoctorHelper.convertRecordStatus(
                    it.status,
                    currentTime,
                    it.start,
                    it.end
                ) == RecordType.TYPE_MISSED
            }
        }
        RecordType.TYPE_COMPLETED -> {
            list.filter {
                TeleDoctorHelper.convertRecordStatus(
                    it.status,
                    currentTime,
                    it.start,
                    it.end
                ) == RecordType.TYPE_COMPLETED
            }
        }
        RecordType.TYPE_CANCELLED -> {
            list.filter {
                TeleDoctorHelper.convertRecordStatus(
                    it.status,
                    currentTime,
                    it.start,
                    it.end
                ) == RecordType.TYPE_CANCELLED
            }
        }
        else -> {
            list.filterIndexed { index, _ ->
                index == 0
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun RecordList(list: List<Item>, currentTime: String, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight()
    ) {

        itemsIndexed(items = list) { index, item ->
            when (TeleDoctorHelper.convertRecordStatus(
                item.status,
                current = currentTime,
                item.start,
                item.end
            )) {
                RecordType.TYPE_UPCOMING -> {
                    UpcomingCard(
                        navController,
                        currentTime,
                        item
                    )
                }
                RecordType.TYPE_HAPPENING_NOW -> {
                    HappeningCard(navController, item)
                }
                RecordType.TYPE_COMPLETED -> {
                    CompletedCard(navController, item)
                }
                RecordType.TYPE_CANCELLED -> {
                    CancelledCard(navController, item)
                }
                RecordType.TYPE_MISSED -> {
                    MissedCard(navController, item)
                }

//                            RecordType.TYPE_HAPPENING_SOON -> {
//                                HappeningCard(navController, item)
//                            }
//                            RecordType.TYPE_BOOKING -> {
//
//                            }
//                            RecordType.TYPE_PENDING_RESULT -> {
//
//                            }
            }
        }

    }
}

private const val ALL = 0
private const val UPCOMING = 1
private const val MISSED = 2
private const val COMPLETED = 3
private const val CANCELLED = 4

