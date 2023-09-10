package com.mclebtec.ideaplugindevelopmentlearning.action

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "Idea Demo", storages = [Storage("my-idea-demo.xml")])
class DataSettings : PersistentStateComponent<DataState> {

    var pluginState = DataState()

    override fun getState(): DataState? {
        return pluginState
    }

    override fun loadState(state: DataState) {
        pluginState = state
    }

    companion object {
        @JvmStatic
        fun getInstance() : PersistentStateComponent<DataState> {
            return ServiceManager.getService(DataSettings::class.java)
        }
    }
}
