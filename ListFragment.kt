package com.example.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentListBinding


class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    var mainActivity: MainActivity? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_list, container, false)
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener { mainActivity?.goDetail() }
        binding.textTitle.text = arguments?.getString("key1")//메인 액티비티의 setFragment()에서 전달 받은 값 꺼내기
        binding.textValue.text = "${arguments?.getInt("key2")}"
        return binding.root
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainActivity) mainActivity = context
    }
    fun setValue(value: String){
        binding.textFromActivity.text = value
    }
}