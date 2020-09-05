package com.rjvjha.android.employee.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.di.components.FragmentComponent
import com.rjvjha.android.employee.ui.base.BaseFragment
import com.rjvjha.android.employee.ui.base.BaseViewModel
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_home_layout.*

class HomeFragment: BaseFragment<HomeViewModel>() {

    companion object {

        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun provideLayoutId(): Int = R.layout.fragment_home_layout

    override fun setupView(view: View) {

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.isEmpListFetching().observe(this, Observer {

            if (it)
                progBar.visibility = View.VISIBLE
            else
                progBar.visibility = View.GONE

        })
        viewModel.getEmpList().observe(this, Observer {
          it?.run { textView.text = this.toString() }
        })
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }


}