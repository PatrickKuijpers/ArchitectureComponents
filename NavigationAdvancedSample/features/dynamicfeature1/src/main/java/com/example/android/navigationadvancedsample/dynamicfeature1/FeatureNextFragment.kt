package com.example.android.navigationadvancedsample.dynamicfeature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class FeatureNextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature_next, container, false).also {
            it.findViewById<Button>(R.id.person_list_button).setOnClickListener {
                findNavController().navigate(R.id.action_feature_next_to_person_list)
            }
            it.findViewById<Button>(R.id.person_detail_button).setOnClickListener {
                val bundle = bundleOf("userName" to "Person 1")
                findNavController().navigate(R.id.action_feature_next_to_person_detail, bundle)
            }
        }
    }
}