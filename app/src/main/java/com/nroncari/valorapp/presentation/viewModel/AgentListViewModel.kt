package com.nroncari.valorapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nroncari.valorapp.domain.usecase.GetAgentListUseCase
import com.nroncari.valorapp.presentation.model.AgentPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgentListViewModel(
    private val useCase: GetAgentListUseCase
) : ViewModel() {

    private val _resultSuccess = MutableLiveData<Boolean>().apply { value = false }
    val resultSuccess: LiveData<Boolean> get() = _resultSuccess
    private val _agents = MutableLiveData<List<AgentPresentation>>().apply { listOf<AgentPresentation>() }
    val agents: LiveData<List<AgentPresentation>> get() = _agents

    fun getAgents() {
        viewModelScope.launch(Dispatchers.IO) {

            runCatching {
                useCase()
            }.onSuccess { agentList ->

                _agents.postValue(agentList)
                _resultSuccess.postValue(true)

            }.onFailure {
                Log.e("Error", "Algo de errado não deu certo", it)
                _resultSuccess.postValue(false)
            }
        }
    }
}
