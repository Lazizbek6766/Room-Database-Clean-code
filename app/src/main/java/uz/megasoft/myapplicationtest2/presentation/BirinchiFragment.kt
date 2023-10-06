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
import uz.megasoft.myapplicationtest2.utils.viewBinding

@AndroidEntryPoint
class BirinchiFragment : BaseFragment(R.layout.fragment_birinchi) {

    private val binding by viewBinding { FragmentBirinchiBinding.bind(it) }
    private val viewModel by viewModels<ItemViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() = with(binding) {

        btnSave.setOnClickListener {
            val name = binding.name.text.toString()
            val description = binding.description.text.toString()
            viewModel.saveItem(name, description)
        }

        btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_birinchiFragment_to_ikkinchiFragment)
        }

    }


}