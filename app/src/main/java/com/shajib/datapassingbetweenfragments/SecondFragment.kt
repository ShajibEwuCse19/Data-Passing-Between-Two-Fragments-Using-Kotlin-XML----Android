package com.shajib.datapassingbetweenfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shajib.datapassingbetweenfragments.databinding.FragmentSecondBinding

/**
 * @author Shajib
 * @since Aug 11, 2024
 **/
//receiving data from first fragment using these val
private const val NAME = "name"
private const val AGE = "age"

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    //assign data var
    private var name: String? = null
    private var age: Int? = null

    //create a view [1st step]
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        //get data from bundle and assign the above var [3rd step]
        arguments.let {
            name = it?.getString(NAME)
            age = it?.getInt(AGE)
        }

        return binding.root
    }

    //set the data to the text view [4th step]
    override fun onResume() {
        super.onResume()
        binding.tvName.text = name
        binding.tvAge.text = age.toString()
    }


    //receiving data from first fragment [2nd step]
    companion object{
        fun newInstance(name: String, age: Int) = SecondFragment().apply {
            val bundle = Bundle().apply {
                putString(NAME, name)
                putInt(AGE, age)
            }
            arguments = bundle
        }
    }
}