package com.draja.marsrover.di

import com.draja.marsrover.data.datasource.cloud.RoverCloudDataSource
import com.draja.marsrover.data.repository.RoverRepository
import com.draja.marsrover.data.respository.StubRoverRepositoryImpl
import com.draja.marsrover.domain.GetRoverPositionUseCase
import com.draja.marsrover.domain.MoveRoverUseCase
import com.draja.marsrover.ui.instructions.InstructionsViewModel
import com.draja.marsrover.ui.result.ResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val stubAppModule = module {
    single { RoverCloudDataSource() }
    single<RoverRepository> { StubRoverRepositoryImpl() }

    single { GetRoverPositionUseCase(get()) }
    single { MoveRoverUseCase(get()) }

    viewModel { InstructionsViewModel(get()) }
    viewModel { ResultViewModel(get()) }
}