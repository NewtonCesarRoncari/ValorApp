package com.nroncari.valorapp.di

import com.nroncari.valorapp.data.datasource.AgentRemoteDataSource
import com.nroncari.valorapp.data.datasource.AgentRemoteDataSourceImpl
import com.nroncari.valorapp.data.datasource.WeaponRemoteDataSource
import com.nroncari.valorapp.data.datasource.WeaponRemoteDataSourceImpl
import com.nroncari.valorapp.data.repository.AgentRepositoryImpl
import com.nroncari.valorapp.data.repository.WeaponRepositoryImpl
import com.nroncari.valorapp.data.retrofit.HttpClient
import com.nroncari.valorapp.data.retrofit.RetrofitClient
import com.nroncari.valorapp.data.service.AgentService
import com.nroncari.valorapp.data.service.WeaponService
import com.nroncari.valorapp.domain.repository.AgentRepository
import com.nroncari.valorapp.domain.repository.WeaponRepository
import com.nroncari.valorapp.domain.usecase.GetAgentDetailUseCase
import com.nroncari.valorapp.domain.usecase.GetAgentListUseCase
import com.nroncari.valorapp.domain.usecase.GetWeaponListUseCase
import com.nroncari.valorapp.presentation.viewModel.AgentDetailViewModel
import com.nroncari.valorapp.presentation.viewModel.AgentListViewModel
import com.nroncari.valorapp.presentation.viewModel.WeaponListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModules = module {
    factory { GetAgentListUseCase(repository = get()) }
    factory { GetAgentDetailUseCase(repository = get()) }
    factory { GetWeaponListUseCase(repository = get()) }
}

val presentationModules = module {
    viewModel { AgentListViewModel(useCase = get()) }
    viewModel { AgentDetailViewModel(useCase = get()) }
    viewModel { WeaponListViewModel(useCase = get()) }
}

val dataModules = module {
    factory<AgentRemoteDataSource> { AgentRemoteDataSourceImpl(service = get()) }
    factory<WeaponRemoteDataSource> { WeaponRemoteDataSourceImpl(service = get()) }
    factory<AgentRepository> { AgentRepositoryImpl(remoteDataSource = get()) }
    factory<WeaponRepository> { WeaponRepositoryImpl(remoteDataSource = get()) }
}

val networkModules = module {
    single { RetrofitClient(application = androidContext()).newInstance() }
    single { HttpClient(get()) }
    factory { get<HttpClient>().create(AgentService::class.java) }
    factory { get<HttpClient>().create(WeaponService::class.java) }
}
