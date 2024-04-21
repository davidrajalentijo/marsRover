package com.draja.marsrover.di

import com.draja.marsrover.ui.instructions.MainViewModel
import com.draja.marsrover.data.datasource.cloud.RoverCloudDataSource
import com.draja.marsrover.data.repository.RoverRepository
import com.draja.marsrover.data.repository.RoverRepositoryImpl
import com.draja.marsrover.domain.GetRoverPositionUseCase
import com.draja.marsrover.domain.MoveRoverUseCase
import com.draja.marsrover.ui.result.ResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RoverCloudDataSource() }
    single<RoverRepository> { RoverRepositoryImpl(get()) }

    single { GetRoverPositionUseCase(get()) }
    single { MoveRoverUseCase(get()) }

    viewModel { MainViewModel(get()) }
    viewModel { ResultViewModel(get()) }
}