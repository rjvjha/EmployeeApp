package com.rjvjha.android.employee.ui.home

import android.os.Bundle
import android.view.View
import com.rjvjha.android.employee.di.components.FragmentComponent
import com.rjvjha.android.employee.ui.base.BaseFragment
import com.rjvjha.android.employee.ui.base.BaseViewModel

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


    override fun provideLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun setupView(view: View) {
        TODO("Not yet implemented")
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }


}