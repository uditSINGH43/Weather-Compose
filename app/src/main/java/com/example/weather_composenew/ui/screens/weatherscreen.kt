package com.example.weather_composenew.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun weatherscreen(modifier: Modifier = Modifier, state: WeatherState, onSettingClick: () -> Unit) {


            Column(
                modifier = modifier
                    .padding()
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())

            ) {


                Box(
                    contentAlignment = Center,
                    modifier = Modifier.padding(15.dp)
                ) {
                    Column {
                        AnimatedVisibility(visible = state.status == Status.LOADING) {
                            CircularProgressIndicator()
                            Text(text = "Loading...", fontSize = 12.sp)
                            AnimatedVisibility(visible = state.status == Status.ERROR) {
                                Column {
                                    Text(
                                        text = "ERROR",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.onError
                                    )
                                    Text(
                                        text = state.error,
                                        color = MaterialTheme.colorScheme.onError
                                    )
                                }
                            }
                        }
                    }

                }

                Text(text = "See Forcast")
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Image(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Weather Refresh"
                    )

                }




                AnimatedVisibility(visible = state.status == Status.SUCCESS) {

                    Column {

                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(text = "Weather Details of dehradun (Air Quality)", fontSize = 25.sp)


                        Text(
                            text = "WindSpeed:${state.result.main?.feelsLike ?: "Not Available"}",
                            fontSize = 18.sp
                        )


                        Text(
                            text = "Wind_Gust:${state.result.wind?.gust ?: "Not Available"}",
                            fontSize = 18.sp
                        )


                        Text(
                            text = "Visibility:${state.result.visibility ?: "Not Available"}",
                            fontSize = 18.sp
                        )

                        Text(
                            text = "Humidity:${state.result.main?.humidity ?: "Not Available"}",
                            fontSize = 18.sp
                        )


                    }

                }
            }
        }



