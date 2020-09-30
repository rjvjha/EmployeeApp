package com.rjvjha.android.employee.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.di.components.FragmentComponent
import com.rjvjha.android.employee.ui.base.BaseFragment
import com.rjvjha.android.employee.ui.base.BaseViewModel
import com.rjvjha.android.employee.ui.home.HomeViewModel.Companion.ORDER_BY_ID
import com.rjvjha.android.employee.ui.home.HomeViewModel.Companion.ORDER_BY_NAME
import com.rjvjha.android.employee.ui.home.adapter.EmployeeListAdapter
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_home_layout.*
import javax.inject.Inject

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

    @Inject
    lateinit var listAdapter: EmployeeListAdapter

    @Inject
    lateinit var layoutManager:LinearLayoutManager


    override fun provideLayoutId(): Int = R.layout.fragment_home_layout

    override fun setupObservers() {
        super.setupObservers()

        viewModel.isEmpListFetching().observe(this, Observer {

            if (it)
                progBar.visibility = View.VISIBLE
            else
                progBar.visibility = View.GONE

        })

        viewModel.getEmpList().observe(this, Observer {
          it?.run {
              listAdapter.appendDataUsingDiffUtil(this)}
        })

        viewModel.empListSorted.observe(this, Observer {
            it?.run {
                if(viewModel.currentOrder != -1) listAdapter.dataList.clear()
                listAdapter.appendData(this)
            }
        })
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }


    override fun setupView(view: View) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = listAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.orderByName ->{ viewModel.rearrangeOrder(ORDER_BY_NAME)}
            R.id.orderById -> { viewModel.rearrangeOrder(ORDER_BY_ID) }
        }
        return true
    }
}