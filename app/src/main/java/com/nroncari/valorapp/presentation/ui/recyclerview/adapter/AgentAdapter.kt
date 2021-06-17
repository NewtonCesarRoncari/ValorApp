package com.nroncari.valorapp.presentation.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.nroncari.valorapp.R
import com.nroncari.valorapp.presentation.extension.loadImage
import com.nroncari.valorapp.presentation.model.AgentPresentation

class AgentAdapter(
    private val context: Context,
    private val agents: List<AgentPresentation> = listOf(),
    var onItemClickListener: (uuid: String) -> Unit = {}
) : RecyclerView.Adapter<AgentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_agent, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(agents[position])
    }

    override fun getItemCount() = agents.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var agent: AgentPresentation
        private val image: AppCompatImageView by lazy { itemView.findViewById(R.id.agent_image) }
        private val name: AppCompatTextView by lazy { itemView.findViewById(R.id.agent_name) }
        private val roleName: AppCompatTextView by lazy { itemView.findViewById(R.id.agent_name_role) }

        fun bind(agent: AgentPresentation) {
            this.agent = agent
            agent.bustPortrait.let { imageAddress ->
                if (imageAddress != null) {
                    image.loadImage(imageAddress)
                }
            }
            name.text = agent.displayName
            roleName.text = agent.role?.displayName ?: ""
        }

        init {
            itemView.setOnClickListener {
                if (::agent.isInitialized)
                    onItemClickListener(agent.uuid)
            }
        }
    }
}
