package com.egarlock.androidnavigation.ui.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_two.*
import kotlinx.android.synthetic.main.fragment_two.button

class TwoFragment : BaseFragment() {

    // region - Variables
    // endregion



    // region - Constructors
    // endregion



    // region - Fragment Lifecycle Methods
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            it.findNavController().navigate(R.id.next)
        }
    }
    // endregion



    // region - Private API
    // endregion



    // region - Public API
    // endregion

}