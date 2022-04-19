package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.databinding.ActivityMainBinding

//메인 액티비티에서 메인레이아웃에 접근하는 코드가 없으므로 메인 액티비티에는 바인딩 관련 코드 x
class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var listFragment: ListFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()
        binding.btnSend.setOnClickListener {
            listFragment.setValue("전달할 값")
        }
    }

    private fun setFragment() {
        listFragment = ListFragment()
        var bundle = Bundle()
        bundle.putString("key1", "ListFragment")//프래그 먼트 생성시에 값 전달
        bundle.putInt("key2", 20220101)
        listFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentLayout, listFragment)//프래그먼트를 레이아웃에 추가
        transaction.commit()
    }
    fun goDetail(){
        val detailFragment = DetailFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentLayout, detailFragment)//프래그먼트를 레이아웃에 추가
        transaction.addToBackStack("detail")//스마트폰의 뒤로가기 버튼 사용가능
        transaction.commit()
    }

    fun goBack(){//디테일 프래그먼트에서 뒤로 돌아가기
        onBackPressed()
    }
}