package com.egarlock.androidnavigation.ui.four

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_four.*
import kotlinx.android.synthetic.main.fragment_four.button
import kotlinx.android.synthetic.main.fragment_one.*

class FourFragment : BaseFragment() {

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
        return inflater.inflate(R.layout.fragment_four, container, false)
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