package uz.megasoft.myapplicationtest2.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.megasoft.myapplicationtest2.R
import uz.megasoft.myapplicationtest2.databinding.FragmentBirinchiBinding
import uz.megasoft.myapplicationtest2.databinding.FragmentIkkinchiBinding
import uz.megasoft.myapplicationtest2.presentation.components.ItemAdapter
import uz.megasoft.myapplicationtest2.utils.launchAndRepeatWithViewLifecycle
import uz.megasoft.myapplicationtest2.utils.viewBinding


@AndroidEntryPoint
class IkkinchiFragment : BaseFragment(R.layout.fragment_ikkinchi) {

    private val binding by viewBinding { FragmentIkkinchiBinding.bind(it) }
    private val viewModel by viewModels<ItemListVievModel>()
    private val adapter by lazy { ItemAdapter(this::remove) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loadData()
    }

    private fun setupUI() = with(binding) {
        recyclerItem.adapter = adapter

        tvAllRemove.setOnClickListener {
            viewModel.removeAllItems()
        }

        toolbar.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun loadData() {
        viewModel.items.observe(viewLifecycleOwner) { items ->
            adapter.submitList(items.toMutableList())
        }
    }

    private fun remove(id: Int) {
        viewModel.removeItem(id)
    }

}