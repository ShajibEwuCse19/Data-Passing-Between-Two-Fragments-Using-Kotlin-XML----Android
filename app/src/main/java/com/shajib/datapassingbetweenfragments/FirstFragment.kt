package com.shajib.datapassingbetweenfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shajib.datapassingbetweenfragments.databinding.FragmentFirstBinding

/**
 * @author Shajib
 * @since Aug 11, 2024
 **/
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    //sending data from first fragment to second fragment
    override fun onResume() {
        super.onResume()

        binding.btnSendData.setOnClickListener {
            val secondFragment = SecondFragment.newInstance("Md Shajibul Islam", 23)

            //replace the first fragment with second fragment
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, secondFragment, "SecondFragment").commit()
        }
    }
}