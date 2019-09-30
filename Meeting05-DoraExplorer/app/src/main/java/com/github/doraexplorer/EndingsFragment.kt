package com.github.doraexplorer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.doraexplorer.databinding.FragmentEndingsBinding

/**
 * A simple [Fragment] subclass.
 */
class EndingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingsBinding>(inflater,
            R.layout.fragment_endings, container, false)

        // Ending Buttons Listeners...
        binding.badEndingOneButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[2]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingOneButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[4]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingOneButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[6]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.normalEndingButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[8]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.bestEndingButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[9]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }

        // Enabling/disabling buttons
        if (MyApplication.badEnding) binding.badEndingOneButton.isEnabled = true
        if (MyApplication.normalEnding) binding.normalEndingButton.isEnabled = true
        if (MyApplication.goodEnding) binding.bestEndingButton.isEnabled = true

        return binding.root
    }
}
