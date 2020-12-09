package com.example.android.navigationadvancedsample.dynamicfeature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class FeatureFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature, container, false).also {
            it.findViewById<Button>(R.id.button).setOnClickListener {
                findNavController().navigate(R.id.action_feature_to_feature_next)
            }
        }
    }
}